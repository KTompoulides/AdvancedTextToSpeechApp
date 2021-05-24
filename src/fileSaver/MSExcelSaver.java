package fileSaver;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MSExcelSaver implements  saverInterface {

    @Override
    public boolean writeContentsToFile(File file, String textToWrite) {

        try {

            FileOutputStream outputFile = new FileOutputStream(file);
            XSSFWorkbook excel = new XSSFWorkbook();
            XSSFSheet sheet = excel.createSheet();

            String[] lines = textToWrite.split("\n");
            //System.out.println(lines[0]);
            for (int i = 0; i < lines.length; i++) {


            }

            int rowCount = -1;

            for (String ExcelLines : lines) {
                Row row = sheet.createRow(++rowCount);
                String[] splLines = ExcelLines.split("\t");
                int columnCount = -1;

                for (String field : splLines) {
                    Cell cell = row.createCell(++columnCount);
                    if (field instanceof String) {
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



