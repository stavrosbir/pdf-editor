/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_files;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import mlab_files.MlabFile;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

/**
 *
 * @author stavros
 */
public class PdfPainter {

    float WIDTH = 612, HEIGHT = 792, newLine = 12;
    float marginX = 36, marginY = 54;
    float width = WIDTH - 2 * marginX;
    float startX = marginX, endX = WIDTH - marginX;
    float startY = HEIGHT - marginY, endY = marginY;
    float posX, posY, formatX, formatY;

    PDFont fonts[][] = {{PDType1Font.TIMES_ROMAN, PDType1Font.TIMES_BOLD,
        PDType1Font.TIMES_ITALIC, PDType1Font.TIMES_BOLD_ITALIC},
    {PDType1Font.HELVETICA, PDType1Font.HELVETICA_BOLD,
        PDType1Font.HELVETICA_OBLIQUE, PDType1Font.HELVETICA_BOLD_OBLIQUE},
    {PDType1Font.COURIER, PDType1Font.COURIER_BOLD,
        PDType1Font.COURIER_OBLIQUE, PDType1Font.COURIER_BOLD_OBLIQUE}};

    Color colors[] = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};

    private PDDocument pdf;
    private PDPageContentStream contentStream;

    public PdfPainter() {
    }

    public PdfPainter(float marginX, float marginY) {
        this.marginX = marginX;
        this.marginY = marginY;
    }

    PDDocument compileMlabFile(MlabFile mlf) throws IOException, COSVisitorException {

        String mlfStr = mlf.open();
        pdf = new PDDocument();
        addNewPage();

        String entries[] = mlfStr.split("&;", -2), text;
        ArrayList<String> list;
        int font, params[];
        for (String entry : entries) {
            if (entry.startsWith("NewLine")) {
                insertNewLine();
                continue;
            }
            if (!entry.trim().isEmpty()) {
                String kind = entry.substring(0, entry.indexOf(' ')).trim();
                if (posY + newLine <= endY && !kind.equals("Format")) {
                    contentStream.close();
                    addNewPage();
                }
                switch (kind) {
                    case "Heading1":
                        font = getFont(entry);
                        text = getText(entry);
                        insertHeading(20, font, text);
                        break;
                    case "Heading2":
                        font = getFont(entry);
                        text = getText(entry);
                        insertHeading(18, font, text);
                        break;
                    case "Heading3":
                        font = getFont(entry);
                        text = getText(entry);
                        insertHeading(16, font, text);
                        break;
                    case "Heading4":
                        font = getFont(entry);
                        text = getText(entry);
                        insertHeading(14, font, text);
                        break;
                    case "Image":
                        float scale = getScale(entry);
                        String imagePath = getText(entry);
                        insertImage(scale, imagePath);
                        break;
                    case "Paragraph":
                        params = getInputParams(entry);
                        text = getText(entry);
                        insertParagraph(params[0], params[1], params[2], params[3], text);
                        break;
                    case "Format":
                        params = getInputParams(entry);
                        text = getText(entry);
                        insertFormat(params[0], params[1], params[2], params[3], text);
                        break;
                    case "UnorderedList":
                        params = getInputParams(entry);
                        list = getList(entry);
                        insertUnorderedList(params[0], params[1], params[2], params[3], list);
                        break;
                    case "OrderedList":
                        params = getInputParams(entry);
                        list = getList(entry);
                        insertOrderedList(params[0], params[1], params[2], params[3], list);
                        break;
                }
                insertNewLine();
            }
        }
        contentStream.close();
        return pdf;
    }

    private void addNewPage() throws IOException {
        PDPage newPage = new PDPage();
        pdf.addPage(newPage);
        contentStream = new PDPageContentStream(pdf, newPage, true, true);
        posX = startX;
        posY = startY;
    }

    private void insertHeading(int fontSize, int fontTypeID, String text) throws IOException {
        float leading = 1.25f * fontSize;
        PDFont pdfFont = fonts[fontTypeID - 1][1];
        Color color = colors[0];

        List<String> lines = getFittedLines(text, pdfFont, fontSize);

        startTextAt(posX, posY, pdfFont, fontSize, color);
        for (String line : lines) {
            if (posY < endY) {
                changePage();
                startTextAt(posX, posY, pdfFont, fontSize, color);
            }
            contentStream.drawString(line);
            formatY = posY;
            insertNewLine(leading);
            contentStream.moveTextPositionByAmount(0, -leading);
        }
        contentStream.endText();
    }

    private void insertNewLine() throws IOException {
        posY -= newLine;
        posX = marginX;
    }

    private void insertNewLine(float dif) throws IOException {
        posY -= dif;
        posX = marginX;
    }

    private void insertImage(float scale, String imagePath) throws IOException {
        BufferedImage awtImage = ImageIO.read(new File(imagePath));
        PDXObjectImage ximage = new PDPixelMap(pdf, awtImage);
        float imX = ximage.getWidth() * scale, imY = ximage.getHeight() * scale;
        if (posY - imY < endY) {
            contentStream.close();
            addNewPage();
        }
        contentStream.drawXObject(ximage, posX, posY - imY, imX, imY);
        insertNewLine(imY);
        insertNewLine();
    }

    private int[] getInputParams(String entry) {
        String split[] = entry.split(":", -2);
        int params[] = new int[4];
        params[0] = Integer.valueOf(split[1].substring(0, split[1].indexOf("fontType")).trim());
        params[1] = Integer.valueOf(split[2].substring(0, 1));
        params[2] = Integer.valueOf(split[3].substring(0, 1));
        params[3] = Integer.valueOf(split[4].substring(0, 1));
        return params;
    }

    private int getFont(String entry) {
        int index = entry.indexOf("fontType:");
        String font = entry.substring(index + 9, index + 10);
        return Integer.valueOf(font);
    }

    private String getText(String entry) {
        return entry.substring(entry.indexOf("\n") + 1).trim();
    }

    private float getScale(String entry) {
        int index1 = entry.indexOf("scale:");
        int index2 = entry.indexOf("\n");
        String scale = entry.substring(index1 + 6, index2);
        return Float.valueOf(scale.trim());
    }

    private void insertParagraph(int fontSize, int fontTypeID, int fontStyleID, int fontColorID, String text) throws IOException {
        float leading = 1.5f * fontSize;
        PDFont pdfFont = fonts[fontTypeID - 1][fontStyleID - 1];
        Color color = colors[fontColorID - 1];

        List<String> lines = getFittedLines(text, pdfFont, fontSize);

        startTextAt(posX, posY, pdfFont, fontSize, color);
        for (String line : lines) {
            if (posY < endY) {
                changePage();
                startTextAt(posX, posY, pdfFont, fontSize, color);
            }
            contentStream.drawString(line);
            formatY = posY;
            insertNewLine(leading);
            contentStream.moveTextPositionByAmount(0, -leading);
        }
        contentStream.endText();
    }

    private void insertFormat(int fontSize, int fontTypeID, int fontStyleID, int fontColorID, String text) throws IOException {
        posX = formatX;
        posY = formatY;
        float leading = 1.5f * fontSize, size = 0;
        PDFont pdfFont = fonts[fontTypeID - 1][fontStyleID - 1];
        Color color = colors[fontColorID - 1];

        List<String> lines = new ArrayList<>();
        int lastSpace = -1, spaceIndex;
        boolean firstTime = true;
        while (text.length() > 0) {
            spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0) {
                spaceIndex = text.length();
            }
            String subString = text.substring(0, spaceIndex);
            size = fontSize * pdfFont.getStringWidth(subString) / 1000;
            if (size + formatX > width + marginX) {
                formatX = marginX;
                if (firstTime) {
                    lines.add("");
                    continue;
                }
                if (lastSpace < 0) {
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
            firstTime = false;
        }
        formatX = size + marginX;

        startTextAt(posX, posY, pdfFont, fontSize, color);
        for (String line : lines) {
            if (posY < endY) {
                changePage();
                startTextAt(posX, posY, pdfFont, fontSize, color);
            }
            contentStream.drawString(line);
            formatY = posY;

            float move = marginX - posX;
            insertNewLine(leading);
            contentStream.moveTextPositionByAmount(move, -leading);
        }
        contentStream.endText();
    }

    private ArrayList<String> getList(String entry) {
        ArrayList<String> list = new ArrayList<>();
        String lines[] = entry.split("\n", -2);
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                list.add(line.trim());
            }
        }
        list.remove(0);
        return list;
    }

    private void insertUnorderedList(int fontSize, int fontTypeID, int fontStyleID, int fontColorID, ArrayList<String> list) throws IOException {
        float leading = 1.5f * fontSize;
        PDFont pdfFont = fonts[fontTypeID - 1][fontStyleID - 1];
        Color color = colors[fontColorID - 1];

        startTextAt(posX + 24, posY, pdfFont, fontSize, color);
        for (String element : list) {
            if (posY < endY) {
                changePage();
                startTextAt(posX + 24, posY, pdfFont, fontSize, color);
            }
            contentStream.drawString("- " + element);
            insertNewLine(leading);
            contentStream.moveTextPositionByAmount(0, -leading);
        }
        contentStream.endText();
    }

    private void insertOrderedList(int fontSize, int fontTypeID, int fontStyleID, int fontColorID, ArrayList<String> list) throws IOException {
        float leading = 1.5f * fontSize;
        PDFont pdfFont = fonts[fontTypeID - 1][fontStyleID - 1];
        Color color = colors[fontColorID - 1];

        startTextAt(posX + 24, posY, pdfFont, fontSize, color);
        int num = 0;
        for (String element : list) {
            if (posY < endY) {
                changePage();
                startTextAt(posX + 24, posY, pdfFont, fontSize, color);
            }
            num++;
            contentStream.drawString(num + ". " + element);
            insertNewLine(leading);
            contentStream.moveTextPositionByAmount(0, -leading);
        }
        contentStream.endText();
    }

    private void changePage() throws IOException {
        contentStream.endText();
        contentStream.close();
        addNewPage();
    }

    private void startTextAt(float X, float Y, PDFont font, int size, Color color) throws IOException {
        contentStream.beginText();
        contentStream.setFont(font, size);
        contentStream.setNonStrokingColor(color);
        contentStream.moveTextPositionByAmount(X, Y);
    }

    private List<String> getFittedLines(String text, PDFont font, int fontSize) throws IOException {
        List<String> lines = new ArrayList<>();
        int lastSpace = -1, spaceIndex;
        float size = 0;
        while (text.length() > 0) {
            spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0) {
                spaceIndex = text.length();
            }
            String subString = text.substring(0, spaceIndex);
            size = fontSize * font.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0) {
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        formatX = size + marginX;
        return lines;
    }

}
