import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame=new JFrame();//creating object of JFrame class
    JButton button=new JButton("TTS");//Creating object of JButton class
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
        frame.setBounds(200,200,400,400);//Setting Location and Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation


    }
    public void buttonProperties(){
        button.setBounds(130,200,100,40);//Setting location and size of button
        frame.add(button);//adding button to the frame
        button.addActionListener(this);
    }

    public void sliderProperties(){
        JSlider rateSlider = new JSlider(0, 200, 120);
        rateSlider.setPaintTrack(true);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        // set spacing
        rateSlider.setMajorTickSpacing(50);
        rateSlider.setMinorTickSpacing(5);
        frame.add(rateSlider);
        // setChangeListener
        //rateSlider.addChangeListener(s);
    }

    public void actionPerformed(ActionEvent e) { //action when button pressed
        frame.getContentPane().setBackground(Color.green);

        tts.tts("I SPEAK NOW",125,95,10);
    }

    public void stateChanged(ChangeEvent e)
    {
        //l.setText("value of Slider is =" + b.getValue());
    }

}