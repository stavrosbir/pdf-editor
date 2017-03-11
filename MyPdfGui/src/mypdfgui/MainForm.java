package mypdfgui;

import files.Omdb;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mlab_files.MlabFile;
import org.apache.pdfbox.exceptions.COSVisitorException;
import pdf_files.PDF;

/**
 *
 * @author stavros
 */
public class MainForm extends javax.swing.JFrame {

    LinkedList<MlabFile> files = new LinkedList<>();
    LinkedList<String> texts = new LinkedList<>();
    int curIndex = -1, lastIndex = -1;

    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMlab = new javax.swing.JFileChooser();
        popUpPdf = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        bHeading1 = new javax.swing.JButton();
        bHeading2 = new javax.swing.JButton();
        bHeading3 = new javax.swing.JButton();
        bHeading4 = new javax.swing.JButton();
        bNewLine = new javax.swing.JButton();
        bImage = new javax.swing.JButton();
        bParagraph = new javax.swing.JButton();
        bFormat = new javax.swing.JButton();
        bUnordered = new javax.swing.JButton();
        bOrdered = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        mNew = new javax.swing.JMenuItem();
        mOpen = new javax.swing.JMenuItem();
        mSave = new javax.swing.JMenuItem();
        mSaveAs = new javax.swing.JMenuItem();
        mClose = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenuItem();
        mEdit = new javax.swing.JMenu();
        mCreate = new javax.swing.JMenuItem();
        mOnlineContent = new javax.swing.JMenuItem();
        mOnlinePDF = new javax.swing.JMenuItem();
        mMerge = new javax.swing.JMenuItem();
        mExtractAll = new javax.swing.JMenuItem();
        mExtract = new javax.swing.JMenuItem();
        mSplit = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        mAbout = new javax.swing.JMenuItem();

        popUpMlab.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        popUpMlab.setFileFilter(new FileNameExtensionFilter("Mlab Files", "mlab"));
        popUpMlab.setMultiSelectionEnabled(true);

        popUpPdf.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        popUpPdf.setFileFilter(new FileNameExtensionFilter("Pdf Files", "pdf"));
        popUpPdf.setMultiSelectionEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bHeading1.setText("Heading1");
        bHeading1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHeading1ActionPerformed(evt);
            }
        });

        bHeading2.setText("Heading2");
        bHeading2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHeading2ActionPerformed(evt);
            }
        });

        bHeading3.setText("Heading3");
        bHeading3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHeading3ActionPerformed(evt);
            }
        });

        bHeading4.setText("Heading4");
        bHeading4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHeading4ActionPerformed(evt);
            }
        });

        bNewLine.setText("NewLine");
        bNewLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewLineActionPerformed(evt);
            }
        });

        bImage.setText("Image");
        bImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImageActionPerformed(evt);
            }
        });

        bParagraph.setText("Paragraph");
        bParagraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParagraphActionPerformed(evt);
            }
        });

        bFormat.setText("Format");
        bFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFormatActionPerformed(evt);
            }
        });

        bUnordered.setText("UnorderedList");
        bUnordered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUnorderedActionPerformed(evt);
            }
        });

        bOrdered.setText("OrderedList");
        bOrdered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrderedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bHeading1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHeading2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHeading3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHeading4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bNewLine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bParagraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFormat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bUnordered)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOrdered)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bHeading1)
                    .addComponent(bHeading2)
                    .addComponent(bHeading3)
                    .addComponent(bHeading4)
                    .addComponent(bNewLine)
                    .addComponent(bImage)
                    .addComponent(bParagraph)
                    .addComponent(bFormat)
                    .addComponent(bUnordered)
                    .addComponent(bOrdered))
                .addContainerGap())
        );

        text.setColumns(20);
        text.setRows(5);
        jScrollPane2.setViewportView(text);

        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        label.setText("File Label");

        mFile.setText("File");

        mNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mNew.setText("New");
        mNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNewActionPerformed(evt);
            }
        });
        mFile.add(mNew);

        mOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mOpen.setText("Open");
        mOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpenActionPerformed(evt);
            }
        });
        mFile.add(mOpen);

        mSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSave.setText("Save");
        mSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveActionPerformed(evt);
            }
        });
        mFile.add(mSave);

        mSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mSaveAs.setText("Save As");
        mSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveAsActionPerformed(evt);
            }
        });
        mFile.add(mSaveAs);

        mClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mClose.setText("Close");
        mClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCloseActionPerformed(evt);
            }
        });
        mFile.add(mClose);

        mExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mExit.setText("Exit");
        mExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExitActionPerformed(evt);
            }
        });
        mFile.add(mExit);

        jMenuBar1.add(mFile);

        mEdit.setText("Edit");

        mCreate.setText("Create PDF");
        mCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCreateActionPerformed(evt);
            }
        });
        mEdit.add(mCreate);

        mOnlineContent.setText("Online Content");
        mOnlineContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOnlineContentActionPerformed(evt);
            }
        });
        mEdit.add(mOnlineContent);

        mOnlinePDF.setText("Online PDF");
        mOnlinePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOnlinePDFActionPerformed(evt);
            }
        });
        mEdit.add(mOnlinePDF);

        mMerge.setText("Merge PDFs");
        mMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMergeActionPerformed(evt);
            }
        });
        mEdit.add(mMerge);

        mExtractAll.setText("Extract All Pages");
        mExtractAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExtractAllActionPerformed(evt);
            }
        });
        mEdit.add(mExtractAll);

        mExtract.setText("Extract Pages");
        mExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExtractActionPerformed(evt);
            }
        });
        mEdit.add(mExtract);

        mSplit.setText("Split PDF");
        mSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSplitActionPerformed(evt);
            }
        });
        mEdit.add(mSplit);

        jMenuBar1.add(mEdit);

        mHelp.setText("Help");

        mAbout.setText("About");
        mAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAboutActionPerformed(evt);
            }
        });
        mHelp.add(mAbout);

        jMenuBar1.add(mHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNewActionPerformed
        savePreviousText();
        if (popUpMlab.showDialog(this, "Create New") == JFileChooser.APPROVE_OPTION) {
            String newFile = popUpMlab.getSelectedFile().getPath();
            MlabFile newMlab = new MlabFile(newFile + ".mlab");
            files.add(newMlab);
            texts.add("");
            lastIndex++;
            refreshList();
            label.setText(newMlab.getName() + " was created");
        }
    }//GEN-LAST:event_mNewActionPerformed

    private void mOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOpenActionPerformed
        savePreviousText();
        if (popUpMlab.showDialog(this, "Open") == JFileChooser.APPROVE_OPTION) {
            try {
                File[] newFiles = popUpMlab.getSelectedFiles();
                for (File newFile : newFiles) {
                    MlabFile newMlab = new MlabFile(newFile.getPath());
                    String cText = newMlab.open();
                    files.add(newMlab);
                    texts.add(cText);
                    lastIndex++;
                }
                refreshList();
                label.setText(newFiles.length + " file(s) opened");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mOpenActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        int testIndex = list.getSelectedIndex();
        if (testIndex != -1) {
            savePreviousText();
            curIndex = testIndex;
            text.setText(texts.get(curIndex));
        }
    }//GEN-LAST:event_listValueChanged

    private void mSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveActionPerformed
        MlabFile toSave = files.get(curIndex);
        String textToSave = text.getText();
        texts.set(curIndex, textToSave);
        try {
            toSave.save(textToSave);
            label.setText(toSave.getName() + " file was saved");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mSaveActionPerformed

    private void mSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveAsActionPerformed
        savePreviousText();
        if (popUpMlab.showDialog(this, "Save As") == JFileChooser.APPROVE_OPTION) {
            try {
                String newFile = popUpMlab.getSelectedFile().getPath();
                String textToSaveAs = text.getText();
                MlabFile newMlab = MlabFile.saveAs(newFile + ".mlab", textToSaveAs);
                files.add(newMlab);
                texts.add(textToSaveAs);
                lastIndex++;
                refreshList();
                label.setText(newMlab.getName() + " file was saved as");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mSaveAsActionPerformed

    private void mCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCloseActionPerformed
        MlabFile removed = files.remove(curIndex);
        texts.remove(curIndex);
        lastIndex--;
        if (lastIndex != -1) {
            text.setText(texts.get(lastIndex));
        }
        refreshList();
        label.setText(removed.getName() + " file was closed");
        removed.close();
    }//GEN-LAST:event_mCloseActionPerformed

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_mExitActionPerformed

    private void mCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCreateActionPerformed
        if (popUpPdf.showDialog(this, "Create PDF") == JFileChooser.APPROVE_OPTION) {
            boolean hiddenException = true;
            try {
                MlabFile toPdf = files.get(curIndex);
                String textToSave = text.getText();
                texts.set(curIndex, textToSave);
                toPdf.save(textToSave);

                PDF newPdf = new PDF(popUpPdf.getSelectedFile().getPath() + ".pdf");
                newPdf.createFromMlabFile(toPdf);
                newPdf.save();
                label.setText(newPdf.getFile().getName() + " file was created");
                newPdf.close();
                hiddenException = false;
            } catch (IOException | COSVisitorException ex) {
                hiddenException = false;
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                if(hiddenException) {
                    JOptionPane.showMessageDialog(this, "The .mlab file is not well formatted!",
                        "Parsing Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_mCreateActionPerformed

    private void mOnlineContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOnlineContentActionPerformed
        String title = JOptionPane.showInputDialog(this, "Give Movie Title!",
                "Fetch Movie Detais", JOptionPane.QUESTION_MESSAGE);
        if (title != null) {
            try {
                String movie = getMovieMlf(title.trim());
                if (movie.startsWith("Omdb says: ")) {
                    JOptionPane.showMessageDialog(this, movie,
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    text.setText(movie);
                    label.setText("Online content was loaded");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mOnlineContentActionPerformed

    private void mOnlinePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOnlinePDFActionPerformed
        String title = JOptionPane.showInputDialog(this, "Give Movie Title!",
                "Fetch Movie Detais", JOptionPane.QUESTION_MESSAGE);
        if (title != null) {
            try {
                String movie = getMovieMlf(title.trim());
                if (movie.startsWith("Omdb says: ")) {
                    JOptionPane.showMessageDialog(this, movie,
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    MlabFile fromMovie = new MlabFile("tempMovie.mlab");
                    fromMovie.save(movie);
                    PDF moviePdf = new PDF("moviePDFs/" + title + ".pdf");
                    moviePdf.createFromMlabFile(fromMovie);
                    moviePdf.save();
                    label.setText(moviePdf.getFile().getName() + " file was created");
                    moviePdf.close();
                }
            } catch (IOException | COSVisitorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mOnlinePDFActionPerformed

    private void mMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMergeActionPerformed
        savePreviousText();
        if (popUpPdf.showDialog(this, "Choose Files") == JFileChooser.APPROVE_OPTION) {
            File[] mergeFiles = popUpPdf.getSelectedFiles();
            //popUpPdf.setSelectedFile(popUpPdf.getCurrentDirectory());
            if (popUpPdf.showDialog(this, "Merge") == JFileChooser.APPROVE_OPTION) {
                String merge = popUpPdf.getSelectedFile().getPath() + ".pdf";
                try {
                    int i = 0;
                    PDF[] pdfsToMerge = new PDF[mergeFiles.length];
                    for (File mergeFile : mergeFiles) {
                        pdfsToMerge[i++] = new PDF(mergeFile.getPath());
                    }
                    PDF.pdfMerge(merge, pdfsToMerge);
                    label.setText(new File(merge).getName() + " file was created");
                } catch (IOException | COSVisitorException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_mMergeActionPerformed

    private void mExtractAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExtractAllActionPerformed
        savePreviousText();
        if (popUpPdf.showDialog(this, "Extract All Pages") == JFileChooser.APPROVE_OPTION) {
            String extract = popUpPdf.getSelectedFile().getPath();
            try {
                PDF extractPdf = new PDF(extract);
                extractPdf.extractAllPages();
                label.setText("All pages were extracted from " + extractPdf.getFile().getName());
            } catch (IOException | COSVisitorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mExtractAllActionPerformed

    private void mExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExtractActionPerformed
        savePreviousText();
        if (popUpPdf.showDialog(this, "Choose File") == JFileChooser.APPROVE_OPTION) {
            String extract = popUpPdf.getSelectedFile().getPath();
            String range = JOptionPane.showInputDialog(this,
                    "Give range of pages to extract.\nUsage: startPage-endPage",
                    "Extract Pages", JOptionPane.QUESTION_MESSAGE);
            if (range != null) {
                String pattern = "(\\d+)-(\\d+)";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(range.trim());
                if (m.matches()) {
                    try {
                        String split[] = range.split("-");
                        int start = Integer.valueOf(split[0]);
                        int end = Integer.valueOf(split[1]);
                        PDF extractPdf = new PDF(extract);
                        if (extractPdf.extractSubPdf(start, end)) {
                            label.setText("Pages " + range + " were extracted from " + extractPdf.getFile().getName());
                        } else {
                            JOptionPane.showMessageDialog(this, "Range of pages is out of bounds!",
                                    "Out of Bounds", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException | COSVisitorException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usage: startPage-endPage",
                            "Wrong Format", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_mExtractActionPerformed

    private void mSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSplitActionPerformed
        savePreviousText();
        if (popUpPdf.showDialog(this, "Choose File") == JFileChooser.APPROVE_OPTION) {
            String split = popUpPdf.getSelectedFile().getPath();
            String range = JOptionPane.showInputDialog(this,
                    "Give page to split Pdf.\nUsage: pageToSplit",
                    "Split Pdf", JOptionPane.QUESTION_MESSAGE);
            if (range != null) {
                String pattern = "(\\d+)";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(range.trim());
                if (m.matches()) {
                    try {
                        int page = Integer.valueOf(range);
                        PDF splitPdf = new PDF(split);
                        if (splitPdf.splitAtPage(page)) {
                            label.setText(splitPdf.getFile().getName() + " was splitted at " + page);
                        } else {
                            JOptionPane.showMessageDialog(this, "Page is out of bounds!",
                                    "Out of Bounds", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException | COSVisitorException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usage: pageToSplit",
                            "Wrong Format", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_mSplitActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        JOptionPane.showMessageDialog(this,
                "Pdf Manager Application, 2016\nDeveloper: Stavros Birmpilis\ne-mail: s.birmpilis@gmail.com",
                "About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("aboutIcon.jpg"));
    }//GEN-LAST:event_mAboutActionPerformed

    private void bHeading1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHeading1ActionPerformed
        String heading1 = "&;Heading1 fontType:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + heading1);
    }//GEN-LAST:event_bHeading1ActionPerformed

    private void bHeading2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHeading2ActionPerformed
        String heading2 = "&;Heading2 fontType:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + heading2);
    }//GEN-LAST:event_bHeading2ActionPerformed

    private void bHeading3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHeading3ActionPerformed
        String heading3 = "&;Heading3 fontType:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + heading3);
    }//GEN-LAST:event_bHeading3ActionPerformed

    private void bHeading4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHeading4ActionPerformed
        String heading4 = "&;Heading4 fontType:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + heading4);
    }//GEN-LAST:event_bHeading4ActionPerformed

    private void bNewLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewLineActionPerformed
        String newLine = "&;NewLine";
        String cText = text.getText() + "\n\n";
        text.setText(cText + newLine);
    }//GEN-LAST:event_bNewLineActionPerformed

    private void bImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImageActionPerformed
        String image = "&;Image scale:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + image);
    }//GEN-LAST:event_bImageActionPerformed

    private void bParagraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParagraphActionPerformed
        String paragraph = "&;Paragraph fontSize: fontType: fontStyle: fontColor:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + paragraph);
    }//GEN-LAST:event_bParagraphActionPerformed

    private void bFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFormatActionPerformed
        String format = "&;Format fontSize: fontType: fontStyle: fontColor:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + format);
    }//GEN-LAST:event_bFormatActionPerformed

    private void bUnorderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUnorderedActionPerformed
        String unordered = "&;UnorderedList fontSize: fontType: fontStyle: fontColor:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + unordered);
    }//GEN-LAST:event_bUnorderedActionPerformed

    private void bOrderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrderedActionPerformed
        String ordered = "&;OrderedList fontSize: fontType: fontStyle: fontColor:";
        String cText = text.getText() + "\n\n";
        text.setText(cText + ordered);
    }//GEN-LAST:event_bOrderedActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFormat;
    private javax.swing.JButton bHeading1;
    private javax.swing.JButton bHeading2;
    private javax.swing.JButton bHeading3;
    private javax.swing.JButton bHeading4;
    private javax.swing.JButton bImage;
    private javax.swing.JButton bNewLine;
    private javax.swing.JButton bOrdered;
    private javax.swing.JButton bParagraph;
    private javax.swing.JButton bUnordered;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JList list;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mClose;
    private javax.swing.JMenuItem mCreate;
    private javax.swing.JMenu mEdit;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenuItem mExtract;
    private javax.swing.JMenuItem mExtractAll;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenuItem mMerge;
    private javax.swing.JMenuItem mNew;
    private javax.swing.JMenuItem mOnlineContent;
    private javax.swing.JMenuItem mOnlinePDF;
    private javax.swing.JMenuItem mOpen;
    private javax.swing.JMenuItem mSave;
    private javax.swing.JMenuItem mSaveAs;
    private javax.swing.JMenuItem mSplit;
    private javax.swing.JFileChooser popUpMlab;
    private javax.swing.JFileChooser popUpPdf;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables

    private void refreshList() {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        files.stream().map((mlf) -> mlf.getName()).forEach((filename) -> {
            dlm.addElement(filename);
        });
        list.setModel(dlm);
        if (lastIndex != -1) {
            text.setText(texts.get(lastIndex));
            list.setSelectedIndex(lastIndex);
        }
    }

    private void savePreviousText() {
        if (curIndex != -1 && curIndex < texts.size()) {
            texts.set(curIndex, text.getText());
        }
    }

    private String getMovieMlf(String title) throws IOException {
        String[] movieDetails = Omdb.getMovieDetails(title);
        if (movieDetails[0].equals("OK")) {
            StringBuilder sb = new StringBuilder();
            sb.append("&;Heading1 fontType:1\n");
            sb.append(movieDetails[1]).append("\n\n");
            sb.append("&;Heading3 fontType:1\n");
            sb.append(movieDetails[2]).append(" - ").append(movieDetails[3])
                    .append(" - ").append(movieDetails[4]).append("\n\n");
            sb.append("&;Paragraph fontSize:12 fontType:1 fontStyle:1 fontColor:1\n");
            sb.append(movieDetails[5]).append("\n\n");
            return sb.toString();
        } else {
            return "Omdb says: " + movieDetails[0];
        }
    }
}
