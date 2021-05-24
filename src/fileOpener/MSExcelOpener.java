package fileOpener;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class MSExcelOpener implements openerInterface{
    @Override
    public String getFileContents(File file) {
        String outString = "";
        try {
            FileInputStream inputFile = new FileInputStream(file);
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
        } catch (Exception e2) {
            System.out.println("File not found \ngeneral I/O Error");
            return null;
        }
        return outString;
    }
}
