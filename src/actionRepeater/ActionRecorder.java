package actionRepeater;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ActionRecorder {
    //private Object action;
    private ArrayList<ActionEvent> actionsList = new ArrayList<ActionEvent>();
    private int counter = 0;
    //private ArrayList<Integer> volumeSliderChanges = new ArrayList<Integer>();



    public void addAction(ActionEvent action){
        actionsList.add(action);
    }

    public ArrayList<ActionEvent> getActionsList(){
        return actionsList;
    }

    public void clearActions(){
        actionsList.clear();
    }

    public Object getFirstAction(){
        Object act = actionsList.get(0);
        actionsList.remove(0);
        return act;
    }

    public Object getNextAction(){
        Object act = actionsList.get(counter);
        counter++;
        return  act;

    }

    public boolean isEmpty(){
        if(actionsList.size()==0) return true;
        return false;
    }

    public boolean counterMaxed(){
        if(counter == actionsList.size()) return true;
        return false;
    }
}
