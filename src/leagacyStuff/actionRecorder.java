package leagacyStuff;

import java.util.ArrayList;

public class actionRecorder {

    //private Object action;
    private ArrayList<Object> actionsList = new ArrayList<Object>();
    private int counter = 0;
    //private ArrayList<Integer> volumeSliderChanges = new ArrayList<Integer>();


    public actionRecorder(){
        actionsList.clear();
    }

    public void addAction(Object action){
        Object act = new Object();
        act = action;
        actionsList.add(act);
    }

    public ArrayList<Object> getActionsList(){
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
