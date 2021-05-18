import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

class ActionEventDemo implements ActionListener,ChangeListener {
    JFrame frame=new JFrame();//creating object of JFrame class
    JButton button;//Creating object of JButton class
    JButton button2;//Creating object of JButton class
    JButton button3;
    JButton openButton;
    JButton atbashButton;
    JButton playButton;
    JButton saveButton;
    //slider control objects
    JSlider rateSlider = new JSlider(0, 200, 120);
    JSlider pitchSlider = new JSlider(0, 200, 95);
    JSlider volumeSlider = new JSlider(0, 100, 75);
    //label objects for slider controls
    JLabel rateLabel = new JLabel();
    JLabel pitchLabel = new JLabel();
    JLabel volumeLabel = new JLabel();

    JTextArea textBox;
    JScrollPane scrollableTextArea;

    private actionRecorder recorder = new actionRecorder();
    private boolean playbackActive = false;

    private TtsBase tts;



    ActionEventDemo(){
        prepareGUI();//calling prepareGUI() method
        buttonProperties();//Calling buttonProperties() method
        sliderProperties();
        labelProperties();
        textBoxProperties();
        tts = new TtsBase();
    }

    public void prepareGUI(){
        frame.setTitle("My Window");//Setting title of JFrame
        frame.getContentPane().setLayout(null);//Setting Layout
        frame.setVisible(true);
        frame.setBounds(1000,800,1000,800);//Setting Location and Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation


    }
    public void buttonProperties(){
        button = new JButton("PLAY ALL");
        button.setBounds(840,250,100,40);//Setting location and size of button
        frame.add(button);//adding button to the frame
        button.addActionListener(this);

        button2 = new JButton("PLAY SELECTED");
        button2.setBounds(840,200,140,40);//Setting location and size of button
        frame.add(button2);//adding button to the frame
        button2.addActionListener(this);

        button3 = new JButton("ENCRYPT ROT-13");
        button3.setBounds(700,400,180,40);//Setting location and size of button
        frame.add(button3);//adding button to the frame
        button3.addActionListener(this);

        openButton = new JButton("Open file");
        openButton.setBounds(700,550,140,40);//Setting location and size of button
        frame.add(openButton);//adding button to the frame
        openButton.addActionListener(this);

        saveButton = new JButton("Save file");
        saveButton.setBounds(700,250,140,40);//Setting location and size of button
        frame.add(saveButton);//adding button to the frame
        saveButton.addActionListener(this);

        atbashButton = new JButton("ENCRYPT ATBASH");
        atbashButton.setBounds(700,450,180,40);//Setting location and size of button
        frame.add(atbashButton);//adding button to the frame
        atbashButton.addActionListener(this);

        playButton = new JButton("ACTIONS REPLAY");
        playButton.setBounds(700,350,180,40);//Setting location and size of button
        frame.add(playButton);//adding button to the frame
        playButton.addActionListener(this);




    }

    public void sliderProperties(){
        rateSlider.setBounds(825,50,150,40); //Speech rate control
        rateSlider.setPaintTrack(true);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        rateSlider.setMajorTickSpacing(100);
        rateSlider.setMinorTickSpacing(20);
        rateSlider.addChangeListener(this);
        frame.add(rateSlider);

        pitchSlider.setBounds(825,100,150,40); //Speech pitch control
        pitchSlider.setPaintTrack(true);
        pitchSlider.setPaintTicks(true);
        pitchSlider.setPaintLabels(true);
        pitchSlider.setMajorTickSpacing(100);
        pitchSlider.setMinorTickSpacing(20);
        pitchSlider.addChangeListener(this);
        frame.add(pitchSlider);

        volumeSlider.setBounds(825,150,150,40); //Speech volume control
        volumeSlider.setPaintTrack(true);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setMajorTickSpacing(100);
        volumeSlider.setMinorTickSpacing(20);
        volumeSlider.addChangeListener(this);
        frame.add(volumeSlider);

    }

    public void labelProperties(){
        rateLabel.setText("Speech Pitch:");
        rateLabel.setBounds(700,90,150,40);
        frame.add(rateLabel);

        pitchLabel.setText("Speech Volume:");
        pitchLabel.setBounds(700,140,150,40);
        frame.add(pitchLabel);

        volumeLabel.setText("Speech Rate:");
        volumeLabel.setBounds(700,40,150,40);
        frame.add(volumeLabel);
    }

    public void textBoxProperties() {
        textBox = new JTextArea();
        scrollableTextArea = new JScrollPane(textBox);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(20,20,650,700);
        //scrollableTextArea.setToolTipText("text");
        //scrollableTextArea.setToolTipText("text");
        //textBox.setBounds(20,20,650,600);
        //textBox.setText("Type here!");
        frame.add(scrollableTextArea);

    }

    public void actionPerformed(ActionEvent e) { //action when button pressed
        ArrayList<Object> sourceList = null;

        Object source = e.getSource();
        recorder.addAction(source);

        if(source.equals(button)){
            tts.tts(textBox.getText(),rateSlider.getValue(),pitchSlider.getValue(),(float) volumeSlider.getValue()/100 );
        }
        else if (source.equals(button2)){
            if(textBox.getSelectedText()==null || textBox.getSelectedText()==""){
                JOptionPane.showMessageDialog(frame, "No text selected! \nPlease select some text");
            }
            else {
                tts.tts(textBox.getSelectedText(), rateSlider.getValue(), pitchSlider.getValue(), (float) volumeSlider.getValue() / 100);
            }
        }

        else  if (source.equals(button3)){
            Encryptor enc = new Encryptor(textBox.getText());
            enc.encryptROT13();
            textBox.setText(enc.getEncryptedText());
        }
        else if(source.equals(openButton)){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                recorder.addAction(file);
                documentManipulator docM = new documentManipulator(file);
                if (!docM.openMSOfficeDocument()) JOptionPane.showMessageDialog(frame, "Unknown filetype! \nOnly .docx and .xlx documents are supported");
                textBox.setText(docM.getPlainText());

            }


        }
        else if(source.equals(atbashButton)){
            Encryptor enc = new Encryptor(textBox.getText());
            enc.encryptAtbash();
            textBox.setText(enc.getEncryptedText());

        }
        else if(source.equals(playButton)){
            while(!recorder.counterMaxed()){
                actionPlayback(recorder.getNextAction());
            }


        }

        else if(source.equals(saveButton)){
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            j.setDialogType(JFileChooser.SAVE_DIALOG);
            j.setFileFilter(new FileNameExtensionFilter(".xlsx","xlsx"));
            // j.setFileFilter(new FileNameExtensionFilter(".docx","docx"));


            int ret = j.showSaveDialog(saveButton);


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
                    JOptionPane.showMessageDialog(frame, "ERROR!");
                }

            }
        }



    }

    public void actionPlayback(Object source) { //action when button pressed


        if(source.equals(button)){
            tts.tts(textBox.getText(),rateSlider.getValue(),pitchSlider.getValue(),(float) volumeSlider.getValue()/100 );
        }
        else if (source.equals(button2)){
            if(textBox.getSelectedText()==null || textBox.getSelectedText()==""){
                JOptionPane.showMessageDialog(frame, "No text selected! \nPlease select some text");
            }
            else {
                tts.tts(textBox.getSelectedText(), rateSlider.getValue(), pitchSlider.getValue(), (float) volumeSlider.getValue() / 100);
            }
        }

        else  if (source.equals(button3)){
            Encryptor enc = new Encryptor(textBox.getText());
            enc.encryptROT13();
            textBox.setText(enc.getEncryptedText());
        }
        else if(source.equals(openButton)){
            //JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            //int returnValue = fileChooser.showOpenDialog(null);

            if (true) {
                File file = (File) recorder.getNextAction();
                documentManipulator docM = new documentManipulator(file);
                if (!docM.openMSOfficeDocument()) JOptionPane.showMessageDialog(frame, "Unknown filetype! \nOnly .docx and .xlx documents are supported");
                textBox.setText(docM.getPlainText());

            }


        }
        else if(source.equals(atbashButton)){
            Encryptor enc = new Encryptor(textBox.getText());
            enc.encryptAtbash();
            textBox.setText(enc.getEncryptedText());

        }

        else if(source.equals(volumeSlider)){
            JSlider js = (JSlider) source;
            System.out.println("VOLUME SLIDER PLAYBACK!!! " + js.getValue() );
            volumeSlider.setValue(js.getValue());
        }
        else if(source.equals(rateSlider)){
            JSlider js = (JSlider) source;
            rateSlider.setValue(js.getValue());
        }
        else if(source.equals(pitchSlider)){
            JSlider js = (JSlider) source;
            pitchSlider.setValue(js.getValue());
        }




    }

    public void stateChanged(ChangeEvent e)
    {
        //System.out.println(e.getSource());

        recorder.addAction(e.getSource());
    }

}