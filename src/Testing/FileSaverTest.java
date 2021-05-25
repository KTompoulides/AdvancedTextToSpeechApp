/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is a test class for the file opening system it checks if files are saved and the saved contents are correct

package Testing;

import fileSaver.SaverFactory;
import fileSaver.SaverInterface;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileSaverTest {
	
	@Test
	public void wordSaverTest() {

		SaverInterface saver = SaverFactory.createSaver("word");
		boolean outputTest = saver.writeContentsToFile((new File("./Test/outputTest.docx")) , "Hi!!" ); //provided test file

		assertTrue(outputTest);
	}
	
	@Test
	public void excelSaverTest() {

		SaverInterface saver = SaverFactory.createSaver("excel");
		boolean outputTest = saver.writeContentsToFile((new File("./Test/outputTest.xlsx")) , """
				TEST 3\tTEST 4\tTEST 5\t\s
				12\t13\t14\t\s
				15\t16\t17\t\s
				18\t19\t20\t\s
				""");

		assertTrue(outputTest);
	}
	

}
