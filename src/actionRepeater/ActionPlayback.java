package actionRepeater;

import fileOpener.openerFactory;
import fileSaver.saverFactory;
import fileSaver.saverInterface;
import graphicalInterface.mainGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ActionPlayback {
    private ArrayList<ActionEvent> actionsList;


    public void replayActions(ActionRecorder recorder){

        actionsList = recorder.getActionsList();
        for(ActionEvent ob :actionsList){

            System.out.println("playin!!!");
            mainGUI mg = new mainGUI();
            mg.actionPerformed(ob);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //mg.stateChanged((ChangeEvent) ob);

        }

    }
}
