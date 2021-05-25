/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Saver class which saves in .xlsx format
package fileSaver;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class MSExcelSaver implements SaverInterface {

    @Override
    public boolean writeContentsToFile(File file, String textToWrite) {

        try {

            FileOutputStream outputFile = new FileOutputStream(file);
            XSSFWorkbook excel = new XSSFWorkbook();
            XSSFSheet sheet = excel.createSheet();
            String[] lines = textToWrite.split("\n");
            int rowCount = -1;

            for (String ExcelLines : lines) {
                Row row = sheet.createRow(++rowCount);
                String[] splLines = ExcelLines.split("\t");
                int columnCount = -1;

                for (String field : splLines) {
                    Cell cell = row.createCell(++columnCount);
                    if (field != null) {
                        cell.setCellValue((String) field);
                    }
                }

            }
            excel.write(outputFile);
            excel.close();
        } catch (Exception e1) {
            System.out.println("Unable to write file \nCheck permisiions!");
            return false;
        }
        return true;
    }
}



