package pdf_files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import mlab_files.MlabFile;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.Splitter;

/**
 *
 * @author stavros
 */
public class PDF {

    private final File file;
    private final String filename;
    private PDDocument pdf;

    public PDF(String name) {
        filename = name;
        file = new File(filename);
    }

    public void loadFromFile() throws IOException {
        pdf = PDDocument.load(file);
    }

    public void close() throws IOException {
        pdf.close();
    }

    public void createFromMlabFile(MlabFile mlf) throws IOException, COSVisitorException {
        PdfPainter pp = new PdfPainter();
        pdf = pp.compileMlabFile(mlf);
    }

    public void save() throws IOException, COSVisitorException {
        pdf.save(file);
    }

    public PDDocument getPdfDoc() {
        return this.pdf;
    }

    public File getFile() {
        return this.file;
    }

    public static void pdfMerge(String filePath, PDF[] pdfsToMerge) throws IOException, COSVisitorException {
        PDFMergerUtility ut = new PDFMergerUtility();
        for (PDF pdfToMerge : pdfsToMerge) {
            ut.addSource(pdfToMerge.getFile());
        }
        ut.setDestinationFileName(filePath);
        ut.mergeDocuments();
    }

    public void extractAllPages() throws IOException, COSVisitorException {
        loadFromFile();
        File path = new File(rmExt(file.getAbsolutePath()) + "_all_pages");
        path.mkdir();
        Splitter splitter = new Splitter();
        List<PDDocument> splittedDocuments = splitter.split(pdf);
        int pi = 0;
        for (PDDocument pageDoc : splittedDocuments) {
            pi++;
            pageDoc.save(path.getPath() + "/" + rmExt(file.getName()) + "_page_" + pi + ".pdf");
            pageDoc.close();
        }
        close();
    }

    public boolean extractSubPdf(int start, int end) throws IOException, COSVisitorException {
        loadFromFile();
        if (start <= 0 || end < start || pdf.getNumberOfPages() < end) {
            return false;
        }
        Splitter splitter = new Splitter();
        splitter.setStartPage(start);
        splitter.setSplitAtPage(end);
        List<PDDocument> splittedDocuments = splitter.split(pdf);
        splittedDocuments.get(0).save(rmExt(file.getAbsolutePath()) + "_pages_" + start + "to" + end + ".pdf");
        splittedDocuments.get(0).close();
        close();
        return true;
    }

    public boolean splitAtPage(int page) throws IOException, COSVisitorException {
        loadFromFile();
        File path = new File(rmExt(file.getAbsolutePath()) + "_splitted_at_" + page);
        path.mkdir();
        if (page <= 0 || pdf.getNumberOfPages() <= page) {
            return false;
        }
        Splitter splitter;
        List<PDDocument> splittedDocuments;

        splitter = new Splitter();
        splitter.setStartPage(1);
        splitter.setSplitAtPage(page);
        splittedDocuments = splitter.split(pdf);
        splittedDocuments.get(0).save(path.getPath() + "/" + rmExt(file.getName()) + "_part1.pdf");
        splittedDocuments.get(0).close();

        splitter = new Splitter();
        splitter.setStartPage(page + 1);
        splitter.setSplitAtPage(pdf.getNumberOfPages());
        splittedDocuments = splitter.split(pdf);
        splittedDocuments.get(0).save(path.getPath() + "/" + rmExt(file.getName()) + "_part2.pdf");
        splittedDocuments.get(0).close();

        close();
        return true;
    }

    private static String rmExt(String file) {
        return file.substring(0, file.length() - 4);
    }

}
