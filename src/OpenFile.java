import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.StyledDocument;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class OpenFile implements ActionListener {
	
	public JFrame frame;
	
	public static void createWindow() {    
	   
	   JPanel panel = new JPanel();
       JFrame frame = new JFrame("Welcome!");
       frame.setSize(400, 200); 
       frame.setVisible(true);
       frame.add(panel);
       
       JLabel label = new JLabel("Choose a file to insert ");
       panel.add(label);
      
       JButton openButton = new JButton("Open file");
       panel.add(openButton);
       openButton.addActionListener(new OpenFile());

       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       
   }
   

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	    JFileChooser filechoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	    
	    filechoose.addChoosableFileFilter(new FileNameExtensionFilter("docx", "docx"));
	    filechoose.addChoosableFileFilter(new FileNameExtensionFilter("xlsx", "xlsx"));

        int returnValue = filechoose.showOpenDialog(null);
        
        
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
            File file = filechoose.getSelectedFile();
            
            String lastChar = file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4);
            //System.out.println(lastChar);
            
            
            try {
            	
            	if(lastChar.endsWith("docx")) {
            		
            		FileInputStream inputFile = new FileInputStream(file.getAbsolutePath());
                    XWPFDocument document = new XWPFDocument(inputFile);
                    List<XWPFParagraph> paragraphs = document.getParagraphs();
                    
                    for (int i = 0; i < paragraphs.size(); i++) {
                        System.out.println(paragraphs.get(i).getParagraphText());
                    }
                    inputFile.close();
                    
                    
                  
            	}else if (lastChar.endsWith("xlsx")) {
            		
            		FileInputStream inputFile = new FileInputStream(file);
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
	            					System.out.print(ExcelCell.getStringCellValue() + "\t\t\t");  
	            					break;  

            					case NUMERIC:      
	            					System.out.print(ExcelCell.getNumericCellValue() + "\t\t\t");  
	            					break;
            					
            					case BOOLEAN:
                					System.out.print(ExcelCell.getBooleanCellValue() + "\t\t\t");  
                					break;
                					
            						default:  
            					}  
            			}
            			System.out.println("");
            		
            		}
            		
            	}else {
            		// add more here
            		System.out.println("Unknown type of file");
            	}
            	
            	
            	
            }catch(Exception e1) {
            	System.out.println("File not found");
            }
            
        }
        
     
	}
	
	


	   
} 
