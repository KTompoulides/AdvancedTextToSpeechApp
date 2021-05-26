/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Recorder class that saves Objects to an ArrayList currently used to save ActionEvents and ChangeEvents not fully working in conjunction with GUI ,could be improved

package actionRepeater;

import java.util.ArrayList;

public class ActionRecorder implements RecorderInterface {
    private ArrayList<Object> actionsList = new ArrayList<>();
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
        return actionsList.get(0);
    }

    public Object getNextAction(){
        try {
            Object act = actionsList.get(counter);
            counter++;
            return  act;
        }
        catch(Exception e){
            return new Object();
        }


    }

    public boolean isEmpty(){
        return actionsList.size() == 0;
    }

    public boolean counterMaxed(){
        return counter == actionsList.size();
    }

    public void counterReset(){
        counter=0;
    }
}
