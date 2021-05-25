package Testing;

import fileSaver.saverFactory;
import fileSaver.saverInterface;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import fileSaver.saverFactory;
import fileSaver.saverInterface;

public class FileSaverTest {
	
	@Test
	public void wordSaverTest() {

		saverInterface saver = saverFactory.createSaver("word");
		boolean outputTest = saver.writeContentsToFile((new File("./Test/outputTest.docx")) , "Hi!!" ); //provided test file

		assertEquals(outputTest, true);
	}
	
	@Test
	public void excelSaverTest() {

		saverInterface saver = saverFactory.createSaver("excel");
		boolean outputTest = saver.writeContentsToFile((new File("./Test/outputTest.xlsx")) , "TEST 3\tTEST 4\tTEST 5\t \n" +
                "12\t13\t14\t \n" +
                "15\t16\t17\t \n" +
                "18\t19\t20\t \n");

		assertEquals(outputTest, true);
	}
	

}
