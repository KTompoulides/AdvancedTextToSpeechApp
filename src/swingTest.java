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
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.StyledDocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;



public class swingTest implements ActionListener {
	
	
	public static void createWindow() {
	   
	   JPanel panel = new JPanel();
       JFrame frame = new JFrame("Welcome!");
       frame.setSize(400, 200); 
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(panel);
       
       JLabel label = new JLabel("Choose a file to insert ");
       panel.add(label);
      
       JButton openButton = new JButton("Open file");
       panel.add(openButton);
       openButton.addActionListener(new swingTest());

       frame.setVisible(true);
       
       
       
   }
   



	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		
	    JFileChooser filechoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = filechoose.showOpenDialog(null);
        

        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
            File file = filechoose.getSelectedFile();
            
            try {
            	//todo
                //c--> docx l-->xlx
            	FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            	String str = file.getAbsolutePath();
                System.out.println("last char = " + str.charAt(str.length() - 2));
                XWPFDocument document = new XWPFDocument(fis); //docx only
                List<XWPFParagraph> paragraphs = document.getParagraphs();
                for (int i = 0; i < paragraphs.size(); i++) {
                    System.out.println(paragraphs.get(i).getParagraphText());
                }
                fis.close();
            	
            }catch(Exception e1) {
            	System.out.println("File not found");
            }
            
        }
     
	}
	

	/*public static void main(String[] args) {
		createWindow();
		
	}*/
	   
} 
