package leagacyStuff;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

public class documentManipulator {

    private File officeFile;
    private String plainText;

    public documentManipulator(File officeFile){
        this.officeFile=officeFile;

    }

    public boolean openMSOfficeDocument(){
        plainText="";
        String lastChar = officeFile.getAbsolutePath().substring(officeFile.getAbsolutePath().length() - 4);
        
        try {

            if(lastChar.endsWith("docx")) {

                FileInputStream inputFile = new FileInputStream(officeFile.getAbsolutePath());
                XWPFDocument document = new XWPFDocument(inputFile);
                List<XWPFParagraph> paragraphs = document.getParagraphs();

                for (int i = 0; i < paragraphs.size(); i++) {
                    //System.out.println(paragraphs.get(i).getParagraphText());
                    plainText += paragraphs.get(i).getParagraphText() +"\n";
                }
                inputFile.close();
                return true;

            }
            else if (lastChar.endsWith("xlsx")) {
                plainText = "";
                FileInputStream inputFile = new FileInputStream(officeFile);
                XSSFWorkbook excel = new XSSFWorkbook(inputFile);
                XSSFSheet ExcelSheet = excel.getSheetAt(0);
                Iterator<Row> iterator = ExcelSheet.iterator();


                while (iterator.hasNext()) {

                    Row ExcelRow = iterator.next();
                    Iterator<Cell> cellIterator = ExcelRow.cellIterator();

                    while (cellIterator.hasNext()){

                        Cell ExcelCell = cellIterator.next();

                        switch (ExcelCell.getCellType())
                        {
                            case STRING:
                                System.out.print(ExcelCell.getStringCellValue() + "\t\t");
                                plainText += ExcelCell.getStringCellValue() + "\t\t";
                                break;

                            case NUMERIC:
                                System.out.print(ExcelCell.getNumericCellValue() + "\t\t");
                                plainText += ExcelCell.getNumericCellValue() + "\t\t";
                                break;

                            case BOOLEAN:
                                System.out.print(ExcelCell.getBooleanCellValue() + "\t\t");
                                plainText += ExcelCell.getBooleanCellValue() + "\t\t";
                                break;

                            default:
                        }
                    }
                    System.out.println("");
                    plainText += "\n";
                }

            }else {
                // add more here
                System.out.println("Unknown type of file");
                return false;
            }
            return true;
        }
        catch(Exception e1) {
            System.out.println("File not found");
            return false;
        }


    }

    public String getPlainText(){
        return plainText;
    }
}
