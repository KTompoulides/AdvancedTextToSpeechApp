package Testing;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MSWordOpenerTest {

	@Test
	public void testGetFileContents() {
		
		File f = new File("./Test/test.docx");
		String outString="";

		try {
            FileInputStream inputFile = new FileInputStream(f.getAbsolutePath());
            try (XWPFDocument document = new XWPFDocument(inputFile)) {
				List<XWPFParagraph> paragraphs = document.getParagraphs();
				for (int i = 0; i < paragraphs.size(); i++) {
					outString += (paragraphs.get(i).getParagraphText());

				}
			}
            inputFile.close();
			assertEquals(outString, "Hey World!"); //Εδώ τεστάρουμε αν όντως διαβάζει σωστά το αρχείο
			//δοκίμασε να αλλάξεις το string και θα γράψει test failed
			//κάπως έτσι θα γίνει και στα άλλα υπάρχουν και άλλες εντολές assertNull κλπ

        } catch (Exception e1) {
            System.out.println("File not found \ngeneral I/O Error");
            
        }
		
	}

}
