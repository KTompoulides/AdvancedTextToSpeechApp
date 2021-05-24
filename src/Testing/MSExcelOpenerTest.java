package Testing;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;

public class MSExcelOpenerTest {

	@Test
	public void testGetFileContents() {
		
		File f = new File("./Test/test.xlsx");
		
		String outString = "";
		
		
		
        try {
            FileInputStream inputFile = new FileInputStream(f.getAbsolutePath());
            XSSFWorkbook excel = new XSSFWorkbook(inputFile);
            XSSFSheet ExcelSheet = excel.getSheetAt(0);
            Iterator<Row> iterator = ExcelSheet.iterator();


            while (iterator.hasNext()) {

                Row ExcelRow = iterator.next();
                Iterator<Cell> cellIterator = ExcelRow.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell ExcelCell = cellIterator.next();

                    switch (ExcelCell.getCellType()) {
                        case STRING:
                            outString += (ExcelCell.getStringCellValue() + "\t");
                            break;

                        case NUMERIC:
                            outString += (ExcelCell.getNumericCellValue() + "\t");
                            break;

                        case BOOLEAN:
                            outString += (ExcelCell + "\t");
                            break;

                        default:
                    }
                }
                outString += (" " + "\n");

            }

            assertEquals(outString, "TEST 0\tTEST 1\tTEST 2\t \n" +
                    "q\tw\te\t \n" +
                    "a\ts\td\t \n" +
                    "z\tx\tc\t \n"); //Εδώ τεστάρουμε αν όντως διαβάζει σωστά το αρχείο

            //δοκίμασε να αλλάξεις το string και θα γράψει test failed
            //κάπως έτσι θα γίνει και στα άλλα υπάρχουν και άλλες εντολές assertNull κλπ
            //αύριο θα βάλω και το fakeTTSAPI για να μπορέσεις να βγάλεις το test για το TTS όπως έκαναν τα παιδιά πέρυσι
            //peace out

        } catch (Exception e2) {
            System.out.println("File not found \ngeneral I/O Error");
         
        }
	}

}
