package graphicalInterface;

import actionRepeater.ActionPlayback;
import actionRepeater.ActionRecorder;
import encodingControl.encodingFactory;
import encodingControl.encodingInterface;
import fileOpener.openerFactory;
import fileOpener.openerInterface;
import fileSaver.*;
import speechControl.TextToSpeechAPI;
import speechControl.TtsFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class mainGUI implements ActionListener, ChangeListener
{


    private JFrame frame = new JFrame();//creating object of JFrame class
    private JPanel panel = new JPanel();
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

    private JTextArea textBox;
    private JScrollPane scrollableTextArea;
    private Boolean recordEnabled = false;

    private TextToSpeechAPI tts;
    private encodingInterface atbashEncoder;
    private encodingInterface rot13Encoder;
    private openerInterface wordOpener;
    private openerInterface excelOpener;
    private ActionRecorder recorder;

    private Object[] objectToCheck;


    public void prepareGUI(){
        //factories init maybe move it to another method?
        tts = TtsFactory.createTextToSpeechAPI("FreeTTSAdapter");
        atbashEncoder = encodingFactory.createEncodingClass("atbash");
        rot13Encoder = encodingFactory.createEncodingClass("rot13");
        recorder = new ActionRecorder();



        frame.setTitle("Advanced TTS Application");//Setting title of JFrame
        frame.getContentPane().setLayout(null);//Setting Layout
        frame.setSize(1050, 800);
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

        textBoxProperties();
        sliderProperties();
        buttonProperties();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation



    }
    public void buttonProperties(){
        playAllButton = new JButton("PLAY ALL");
        playAllButton.setBounds(840,250,100,40);//Setting location and size of button
        frame.add(playAllButton);//adding button to the frame
        playAllButton.addActionListener(this);

        playSelectedButton = new JButton("PLAY SELECTED");
        playSelectedButton.setBounds(840,200,140,40);//Setting location and size of button
        frame.add(playSelectedButton);//adding button to the frame
        playSelectedButton.addActionListener(this);

        rot13Button = new JButton("ENCRYPT ROT-13");
        rot13Button.setBounds(700,400,180,40);//Setting location and size of button
        frame.add(rot13Button);//adding button to the frame
        rot13Button.addActionListener(this);

        openButton = new JButton("Open file");
        openButton.setBounds(700,550,140,40);//Setting location and size of button
        frame.add(openButton);//adding button to the frame
        openButton.addActionListener(this);

        saveButton = new JButton("Save file");
        saveButton.setBounds(840,550,140,40);//Setting location and size of button
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

        recordButton = new JButton("ACTIONS RECORD");
        recordButton.setBounds(700,300,180,40);//Setting location and size of button
        frame.add(recordButton);//adding button to the frameREPLAY
        recordButton.addActionListener(this);

        clearButton = new JButton("ACTIONS CLEAR");
        clearButton.setBounds(700,600,180,40);//Setting location and size of button
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
        scrollableTextArea = new JScrollPane(textBox);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        scrollableTextArea.setBounds(20,20,650,700);

        //scrollableTextArea.setToolTipText("text");
        //scrollableTextArea.setToolTipText("text");
        //textBox.setBounds(20,20,650,600);
        //textBox.setText("Type here!");
        frame.add(scrollableTextArea);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ACTION!!!!"+e.getSource());
        Object source = e.getSource();
        if (recordEnabled) recorder.addAction(e);

        if(source.equals(playAllButton)){
            tts.playTts(textBox.getText());

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
            recordEnabled = false;
            ActionPlayback player = new ActionPlayback();
            player.replayActions(recorder);


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
                wordOpener = openerFactory.createOpener("word");
                String textToDisplay = wordOpener.getFileContents(file);
                if (textToDisplay!=null) textBox.setText(textToDisplay);
                else JOptionPane.showMessageDialog(frame, "General I/O Error \nCannot open file!");



            }
            else if (file.getAbsolutePath().substring(file.getAbsolutePath().length() - 4).endsWith("xlsx")){
                excelOpener = openerFactory.createOpener("excel");
                String textToDisplay = excelOpener.getFileContents(file);
                if (textToDisplay!=null) textBox.setText(textToDisplay);
                else JOptionPane.showMessageDialog(frame, "General I/O Error \nCannot open file!");

            }
            else{
                JOptionPane.showMessageDialog(frame, "Unknown filetype! \nOnly .docx and .xlsx documents are supported");
            }

        }
        else if(source.equals(saveButton)){

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setDialogType(JFileChooser.SAVE_DIALOG);
            j.setFileFilter(new FileNameExtensionFilter(".xlsx","xlsx"));
            j.setFileFilter(new FileNameExtensionFilter(".docx","docx"));
            int ret = j.showSaveDialog(saveButton);

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = j.getSelectedFile();
                String extension = j.getFileFilter().getDescription();

                if (extension.equals(".docx")) {
                    file = new File(j.getSelectedFile() + ".docx");
                    saverInterface wordSaver = saverFactory.createSaver("word");
                    if (!wordSaver.writeContentsToFile(file, textBox.getText())) {
                        JOptionPane.showMessageDialog(frame, "Cannot write file to disk! \nCheck permissions");
                    }
                } else if (extension.equals(".xlsx")) {
                    file = new File(j.getSelectedFile() + ".xlsx");
                    saverInterface excelSaver = saverFactory.createSaver("excel");
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

        Object slider = e.getSource(); //updates voice parameters when slider is moved
        //if (recordEnabled) recorder.addAction(e);

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
