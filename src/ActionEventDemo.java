import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame=new JFrame();//creating object of JFrame class
    JButton button=new JButton("TTS");//Creating object of JButton class
    //slider control objects
    JSlider rateSlider = new JSlider(0, 200, 120);
    JSlider pitchSlider = new JSlider(0, 200, 95);
    JSlider volumeSlider = new JSlider(0, 100, 75);
    //label objects for slider controls
    JLabel rateLabel = new JLabel();
    JLabel pitchLabel = new JLabel();
    JLabel volumeLabel = new JLabel();

    JTextField textBox;

    private ttsBase tts;

    ActionEventDemo(){
        prepareGUI();//calling prepareGUI() method
        buttonProperties();//Calling buttonProperties() method
        sliderProperties();
        labelProperties();
        textBoxProperties();
        tts = new ttsBase();
    }

    public void prepareGUI(){
        frame.setTitle("My Window");//Setting title of JFrame
        frame.getContentPane().setLayout(null);//Setting Layout
        frame.setVisible(true);
        frame.setBounds(400,400,800,800);//Setting Location and Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation


    }
    public void buttonProperties(){
        button.setBounds(230,550,100,40);//Setting location and size of button
        frame.add(button);//adding button to the frame
        button.addActionListener(this);
    }

    public void sliderProperties(){
        rateSlider.setBounds(250,430,150,40); //Speech rate control
        rateSlider.setPaintTrack(true);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        rateSlider.setMajorTickSpacing(100);
        rateSlider.setMinorTickSpacing(20);
        frame.add(rateSlider);

        pitchSlider.setBounds(250,380,150,40); //Speech pitch control
        pitchSlider.setPaintTrack(true);
        pitchSlider.setPaintTicks(true);
        pitchSlider.setPaintLabels(true);
        pitchSlider.setMajorTickSpacing(100);
        pitchSlider.setMinorTickSpacing(20);
        frame.add(pitchSlider);

        volumeSlider.setBounds(250,330,150,40); //Speech volume control
        volumeSlider.setPaintTrack(true);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setMajorTickSpacing(100);
        volumeSlider.setMinorTickSpacing(20);
        frame.add(volumeSlider);

    }

    public void labelProperties(){
        rateLabel.setText("Speech Rate:");
        rateLabel.setBounds(140,420,150,40);
        frame.add(rateLabel);

        pitchLabel.setText("Speech Pitch:");
        pitchLabel.setBounds(140,370,150,40);
        frame.add(pitchLabel);

        volumeLabel.setText("Speech Volume:");
        volumeLabel.setBounds(140,320,150,40);
        frame.add(volumeLabel);
    }

    public void textBoxProperties() {
        textBox = new JTextField("enter the text", 16);
        textBox.setBounds(20,20,300,100);
        frame.add(textBox);

    }

    public void actionPerformed(ActionEvent e) { //action when button pressed
        //frame.getContentPane().setBackground(Color.green);
        System.out.println(rateSlider.getValue());
        tts.tts(textBox.getText(),rateSlider.getValue(),pitchSlider.getValue(),(float) volumeSlider.getValue()/100 );
    }

    public void stateChanged(ChangeEvent e)
    {
        //l.setText("value of Slider is =" + b.getValue());
    }

}