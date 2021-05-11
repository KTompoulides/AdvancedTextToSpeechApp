import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame=new JFrame();//creating object of JFrame class
    JButton button;//Creating object of JButton class
    JButton button2;//Creating object of JButton class
    //slider control objects
    JSlider rateSlider = new JSlider(0, 200, 120);
    JSlider pitchSlider = new JSlider(0, 200, 95);
    JSlider volumeSlider = new JSlider(0, 100, 75);
    //label objects for slider controls
    JLabel rateLabel = new JLabel();
    JLabel pitchLabel = new JLabel();
    JLabel volumeLabel = new JLabel();

    JTextArea textBox;

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

    }

    public void sliderProperties(){
        rateSlider.setBounds(825,50,150,40); //Speech rate control
        rateSlider.setPaintTrack(true);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        rateSlider.setMajorTickSpacing(100);
        rateSlider.setMinorTickSpacing(20);
        frame.add(rateSlider);

        pitchSlider.setBounds(825,100,150,40); //Speech pitch control
        pitchSlider.setPaintTrack(true);
        pitchSlider.setPaintTicks(true);
        pitchSlider.setPaintLabels(true);
        pitchSlider.setMajorTickSpacing(100);
        pitchSlider.setMinorTickSpacing(20);
        frame.add(pitchSlider);

        volumeSlider.setBounds(825,150,150,40); //Speech volume control
        volumeSlider.setPaintTrack(true);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setMajorTickSpacing(100);
        volumeSlider.setMinorTickSpacing(20);
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
        textBox.setBounds(20,20,650,600);
        textBox.setText("Type here!");
        frame.add(textBox);

    }

    public void actionPerformed(ActionEvent e) { //action when button pressed

        Object source = e.getSource();
        if(source.equals(button)){
            tts.tts(textBox.getText(),rateSlider.getValue(),pitchSlider.getValue(),(float) volumeSlider.getValue()/100 );
        }
        else if (source.equals(button2)){
            tts.tts(textBox.getSelectedText(),rateSlider.getValue(),pitchSlider.getValue(),(float) volumeSlider.getValue()/100 );
        }



    }

    public void stateChanged(ChangeEvent e)
    {
        System.out.println(e);
    }

}