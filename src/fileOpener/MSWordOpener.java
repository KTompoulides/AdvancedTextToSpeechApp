/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Opener class that opens and "reads" .xlsx format files

package fileOpener;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class MSWordOpener implements OpenerInterface {
    @Override
    public String getFileContents(File file) {
        String outString = "";
        try {
            FileInputStream inputFile = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(inputFile);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                outString += (paragraph.getParagraphText());
            }
            inputFile.close();

        } catch (Exception e1) {
            System.out.println("File not found \ngeneral I/O Error");
            return null;
        }
        return outString;
    }
}
