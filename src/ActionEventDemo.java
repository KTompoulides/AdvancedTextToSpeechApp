import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame=new JFrame();//creating object of JFrame class
    JButton button=new JButton("TTS");//Creating object of JButton class
    JSlider rateSlider = new JSlider(0, 200, 120);
    JPanel panel = new JPanel();

    private ttsBase tts;

    ActionEventDemo(){
        prepareGUI();//calling prepareGUI() method
        buttonProperties();//Calling buttonProperties() method
        sliderProperties();
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
        button.setBounds(130,200,100,40);//Setting location and size of button
        frame.add(button);//adding button to the frame
        button.addActionListener(this);
    }

    public void sliderProperties(){
        rateSlider.setBounds(260,400,100,40);
        //rateSlider.setBounds
        rateSlider.setPaintTrack(true);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        // set spacing
        rateSlider.setMajorTickSpacing(50);
        rateSlider.setMinorTickSpacing(10);
        frame.add(rateSlider);
        // setChangeListener
        //rateSlider.addChangeListener(s);
    }

    public void actionPerformed(ActionEvent e) { //action when button pressed
        //frame.getContentPane().setBackground(Color.green);

        tts.tts("I SPEAK NOW",rateSlider.getValue(),95,10);
    }

    public void stateChanged(ChangeEvent e)
    {
        //l.setText("value of Slider is =" + b.getValue());
    }

}