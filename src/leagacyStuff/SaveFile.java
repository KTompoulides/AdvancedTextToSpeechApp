package leagacyStuff;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaveFile implements ActionListener {
	
	JTextArea textArea;
	JButton save;
	
	  public static void save() {
		  
		  JFrame frame = new JFrame("Welcome!");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  JTextArea textArea = new JTextArea();
		  textArea = new JTextArea(30, 90);
		  
		  JButton save = new JButton();
		  save = new JButton("Save");
		  frame.add(new JScrollPane(textArea));
		  JPanel buttonPanel = new JPanel();
		  buttonPanel.add(save);
		  save.addActionListener(new SaveFile());
		  frame.add(buttonPanel, BorderLayout.SOUTH);
		  
		  frame.setSize(350, 250);
		  frame.setVisible(true);
	   	
	  }
	  
	  @Override
	  public void actionPerformed(ActionEvent e) {
		  
		  
		  JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		  
		  j.setDialogType(JFileChooser.SAVE_DIALOG);
		  j.setFileFilter(new FileNameExtensionFilter(".xlsx","xlsx"));
		 // j.setFileFilter(new FileNameExtensionFilter(".docx","docx"));
		  
		  
          int ret = j.showSaveDialog(save);
          
          
          if (ret == JFileChooser.APPROVE_OPTION) {
        	  
        	  File file = j.getSelectedFile();
        	  
        	  String file1 = j.getSelectedFile().toString();
        	  
        	  if (!file1 .endsWith(".xlsx")) {
        		  file1 += ".xlsx";
        	   }
        	        
        	  
        	  System.out.println(file1);
        	  
        	  try {
        		  
        		  FileOutputStream outputFile = new FileOutputStream(file1);
          		  XSSFWorkbook excel = new XSSFWorkbook();
          		  XSSFSheet sheet = excel.createSheet();
          		  excel.write(outputFile);
          		  excel.close();
          		  
        	  }catch(Exception e1) {
        		  System.out.println("Error");
        	  }
        	  
          }
          
          // enalagh se open kai save button
		  //String com = e.getActionCommand();
		  //if (com.equals("save")) {
			   
	  	
	  }
  

}









