/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Recorder interface MUST be implemented by recorder classes

package actionRepeater;

import java.util.ArrayList;

public interface RecorderInterface {

    void addAction(Object action);
    ArrayList<Object> getActionsList();
    void clearActions();
    Object getFirstAction();
    Object getNextAction();
    boolean isEmpty();
    boolean counterMaxed();
}
