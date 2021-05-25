package actionRepeater;

import java.util.ArrayList;

public class ActionRecorder implements RecorderInterface {
    private ArrayList<Object> actionsList = new ArrayList<Object>();
    private int counter = 0;



    public void addAction(Object action){

        actionsList.add(action);
    }

    public ArrayList<Object> getActionsList(){

        return actionsList;
    }

    public void clearActions(){

        actionsList.clear();
    }

    public Object getFirstAction(){
        Object act = actionsList.get(0);
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

    public void counterReset(){
        counter=0;
    }
}
