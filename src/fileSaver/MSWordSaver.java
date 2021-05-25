/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Saver class which saves in .docx format
package fileSaver;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;

public class MSWordSaver implements SaverInterface {
    @Override
    public boolean writeContentsToFile(File file,String textToWrite) {
        try {
            FileOutputStream OutputFile = new FileOutputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(textToWrite);
            document.write(new FileOutputStream(file.getAbsolutePath()));
            OutputFile.close();
        }
        catch(Exception e1){
            System.out.println("Unable to write file \nCheck permisiions!");
            return false;
        }
        return true;
    }
}
