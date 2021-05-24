package Testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;

import fileOpener.MSWordOpener;


public class MSWordOpenerTest {

	@Test
	public void testGetFileContents() {
		
		File f = new File("./AdvancedTextToSpeechApp-master/Test/test.docx");

		
		try {
            FileInputStream inputFile = new FileInputStream(f.getAbsolutePath());
            try (XWPFDocument document = new XWPFDocument(inputFile)) {
				List<XWPFParagraph> paragraphs = document.getParagraphs();
				for (int i = 0; i < paragraphs.size(); i++) {
				}
			}
            inputFile.close();

        } catch (Exception e1) {
            System.out.println("File not found \ngeneral I/O Error");
            
        }
		
	}

}
