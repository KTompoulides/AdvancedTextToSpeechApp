/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

/*
    This is the main class for the graphical interface everything graphical related happens here
 */

package graphicalInterface;

import actionRepeater.RecorderFactory;
import actionRepeater.RecorderInterface;
import encodingControl.EncodingFactory;
import encodingControl.EncodingInterface;
import fileOpener.OpenerFactory;
import fileOpener.OpenerInterface;
import fileSaver.*;
import speechControl.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGUI implements ActionListener, ChangeListener
{


    private JFrame frame = new JFrame();//creating object of JFrame class
    private JButton playAllButton;//Creating object of JButton class
    private JButton playSelectedButton;//Creating object of JButton class
    private JButton rot13Button;
    private JButton openButton;
    private JButton atbashButton;
    private JButton playButton;
    private JButton recordButton;
    private JButton clearButton;
    private JButton saveButton;
    //slider control objects
    private JSlider volumeSlider = new JSlider(0, 100, 80);
    private JSlider pitchSlider = new JSlider(0, 200, 80);
    private JSlider rateSlider = new JSlider(0, 200, 80);
    //label objects for slider controls
    private JLabel rateLabel = new JLabel();
    private JLabel pitchLabel = new JLabel();
    private JLabel volumeLabel = new JLabel();
    private JLabel audioLabel = new JLabel();

    private JTextArea textBox;
    private Boolean recordEnabled = false;

    private TextToSpeechAPI tts;
    private EncodingInterface atbashEncoder;
    private EncodingInterface rot13Encoder;
    private RecorderInterface recorder;

    private Object[] objectToCheck;


    public void initVariables(){ //initializing variables
        tts = TTSFactory.createTextToSpeechAPI("FreeTTSAdapter");
        atbashEncoder = EncodingFactory.createEncodingClass("atbash");
        rot13Encoder = EncodingFactory.createEncodingClass("rot13");
        recorder = RecorderFactory.createRecorder("action");

    }
    public void prepareGUI(){
        frame.setTitle("Advanced TTS Application");//Setting title of JFrame
        frame.getContentPane().setLayout(null);//Setting Layout
        frame.setSize(1100, 800);
        frame.setLocationRelativeTo(null);
        //frame.setBounds(1000,800,1000,800);//Setting Location and Size

        volumeLabel.setText("Speech Rate:");
        volumeLabel.setBounds(700,40,150,40);
        frame.add(volumeLabel);

        rateLabel.setText("Speech Pitch:");
        rateLabel.setBounds(700,90,150,40);
        frame.add(rateLabel);


        pitchLabel.setText("Speech Volume:");
        pitchLabel.setBounds(700,140,150,40);
        frame.add(pitchLabel);

        audioLabel.setText("Speech Transform Controls");
        audioLabel.setBounds(790,05,200,40);
        frame.add(audioLabel);

        JLabel replayLabel = new JLabel();
        replayLabel.setText("Action Record Controls");
        replayLabel.setBounds(810,300,200,40);
        frame.add(replayLabel);

        JLabel encodeLabel = new JLabel();
        encodeLabel.setText("Text Encoding Controls");
        encodeLabel.setBounds(810,500,200,40);
        frame.add(encodeLabel);

        textBoxProperties();
        sliderProperties();
        buttonProperties();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation



    }
    public void buttonProperties(){
        playAllButton = new JButton("PLAY ALL TEXT");
        playAllButton.setBounds(700,210,170,40);//Setting location and size of button
        frame.add(playAllButton);//adding button to the frame
        playAllButton.addActionListener(this);

        playSelectedButton = new JButton("PLAY SELECTED TEXT");
        playSelectedButton.setBounds(900,210,190,40);//Setting location and size of button
        frame.add(playSelectedButton);//adding button to the frame
        playSelectedButton.addActionListener(this);



        openButton = new JButton("OPEN FILE");
        openButton.setBounds(20,10,140,40);//Setting location and size of button
        frame.add(openButton);//adding button to the frame
        openButton.addActionListener(this);

        saveButton = new JButton("SAVE FILE");
        saveButton.setBounds(180,10,140,40);//Setting location and size of button
        frame.add(saveButton);//adding button to the frame
        saveButton.addActionListener(this);

        atbashButton = new JButton("<HTML>ENCRYPT/DECRYPT<BR>ATBASH </HTML>");
        atbashButton.setBounds(900,550,180,70);//Setting location and size of button
        frame.add(atbashButton);//adding button to the frame
        atbashButton.addActionListener(this);

        rot13Button = new JButton("<HTML>ENCRYPT/DECRYPT<BR>ROT-13 </HTML>");
        rot13Button.setBounds(700,550,180,70);//Setting location and size of button
        rot13Button.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(rot13Button);//adding button to the frame
        rot13Button.addActionListener(this);

        playButton = new JButton("REPLAY ACTIONS");
        playButton.setBounds(900,350,180,40);//Setting location and size of button
        frame.add(playButton);//adding button to the frame
        playButton.addActionListener(this);

        recordButton = new JButton("RECORD ACTIONS");
        recordButton.setBounds(700,350,180,40);//Setting location and size of button
        frame.add(recordButton);//adding button to the frameREPLAY
        recordButton.addActionListener(this);

        clearButton = new JButton("CLEAR ACTIONS");
        clearButton.setBounds(800,400,180,40);//Setting location and size of button
        frame.add(clearButton);//adding button to the frameREPLAY
        clearButton.addActionListener(this);


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


    public void textBoxProperties() {
        textBox = new JTextArea();
        JScrollPane scrollableTextArea = new JScrollPane(textBox);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(20,60,650,700);
        frame.add(scrollableTextArea);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //Checks if a button has been pressed
        Object source = e.getSource();
        if (recordEnabled) recorder.addAction(e);

        if(source.equals(playAllButton)){
            if(textBox.getText().strip().equals("")) {
                JOptionPane.showMessageDialog(frame, "There is no text to transform into speech!\nType something in the editor or open a file by clicking OPEN FILE");
            }
            else{
                tts.playTts(textBox.getText());
            }


        }
        else if (source.equals(playSelectedButton)){
            if(textBox.getSelectedText()==null || textBox.getSelectedText()==""){
                JOptionPane.showMessageDialog(frame, "No text selected! \nPlease select some text");
            }
            else {
                tts.playTts(textBox.getSelectedText());
            }
        }

        else if(source.equals(recordButton)){
            recordEnabled = true;
        }
        else if(source.equals(playButton)){
            if(recorder.getActionsList().size()==0){
                JOptionPane.showMessageDialog(frame, "No actions have been recorded!\nPlease click the RECORD ACTIONS button and continue using the application normally.\nYour actions are saved automatically.");
            }
            recordEnabled = false;

            //not fully implemented
            while(!recorder.counterMaxed()){
                Object nextAction = recorder.getNextAction();
                if( nextAction.getClass().toString().equals("class java.awt.event.ActionEvent")){
                    actionPerformed((ActionEvent) nextAction);
                }
                else{
                    stateChanged((ChangeEvent) nextAction);
                }


            }

        }

        else if(source.equals(clearButton)){
            recordEnabled = false;
            recorder.clearActions();

        }

        else  if (source.equals(rot13Button)){
            textBox.setText(rot13Encoder.encode(textBox.getText()));
        }

        else  if (source.equals(atbashButton)){
            textBox.setText(atbashEncoder.encode(textBox.getText()));
        }

        else if(source.equals(openButton)){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".docx", "docx"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".xlsx", "xlsx"));
            fileChooser.showOpenDialog(null);

            File file = fileChooser.getSelectedFile();
            if (file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4).endsWith("docx")){
                OpenerInterface wordOpener = OpenerFactory.createOpener("word");
                String textToDisplay = wordOpener.getFileContents(file);
                if (textToDisplay!=null) textBox.setText(textToDisplay);
                else JOptionPane.showMessageDialog(frame, "General I/O Error \nCannot open file!");



            }
            else if (file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4).endsWith("xlsx")){
                OpenerInterface excelOpener = OpenerFactory.createOpener("excel");
                String textToDisplay = excelOpener.getFileContents(file);
                if (textToDisplay!=null) textBox.setText(textToDisplay);
                else JOptionPane.showMessageDialog(frame, "General I/O Error \nCannot open file!");

            }
            else{
                JOptionPane.showMessageDialog(frame, "Unknown filetype! \nOnly .docx and .xlsx documents are supported");
            }

        }
        else if(source.equals(saveButton)){

            if(textBox.getText().strip().equals("")){
                int opt = JOptionPane.showConfirmDialog(frame, "No text to write! \nThe file that will be created will have no contents, are you sure?");
                if(opt==1||opt==2){
                    return;
                }
            }
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setDialogType(JFileChooser.SAVE_DIALOG);
            j.setFileFilter(new FileNameExtensionFilter(".xlsx","xlsx"));
            j.setFileFilter(new FileNameExtensionFilter(".docx","docx"));
            int ret = j.showSaveDialog(saveButton);

            if (ret == JFileChooser.APPROVE_OPTION) {
                j.getSelectedFile();
                File file;
                String extension = j.getFileFilter().getDescription();

                if (extension.equals(".docx")) {
                    //System.out.println(j.getSelectedFile());
                    if(j.getSelectedFile().toString().endsWith(".docx")){
                        file = new File(j.getSelectedFile().toString());
                    }
                    else{
                        file = new File(j.getSelectedFile() + ".docx");
                    }

                    SaverInterface wordSaver = SaverFactory.createSaver("word");
                    if (!wordSaver.writeContentsToFile(file, textBox.getText())) {
                        JOptionPane.showMessageDialog(frame, "Cannot write file to disk! \nCheck permissions");
                    }
                } else if (extension.equals(".xlsx")) {
                    if(j.getSelectedFile().toString().endsWith(".xlsx")){
                        file = new File(j.getSelectedFile().toString());
                    }
                    else{
                        file = new File(j.getSelectedFile() + ".xlsx");
                    }
                    SaverInterface excelSaver = SaverFactory.createSaver("excel");
                    if (!excelSaver.writeContentsToFile(file, textBox.getText())) {
                        JOptionPane.showMessageDialog(frame, "Cannot write file to disk! \nCheck permissions");
                    }

                } else {
                    JOptionPane.showMessageDialog(frame, "This error message shouldn't be displayed!");
                }
            }

        }

    }

    public void stateChanged(ChangeEvent e) {
        //checks if a slider has been moved

        if (recordEnabled) recorder.addAction(e);

        Object slider = e.getSource();

        if(slider.equals(volumeSlider)){
            tts.setVolume(volumeSlider.getValue());
        }
        else if(slider.equals(rateSlider)){
            tts.setRate(rateSlider.getValue());
        }
        else if(slider.equals(pitchSlider)){
            tts.setPitch(pitchSlider.getValue());
        }


    }

}
