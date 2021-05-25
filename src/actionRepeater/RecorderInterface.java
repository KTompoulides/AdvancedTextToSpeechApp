package actionRepeater;

import java.util.ArrayList;

public interface RecorderInterface {

    public void addAction(Object action);
    public ArrayList<Object> getActionsList();
    public void clearActions();
    public Object getFirstAction();
    public Object getNextAction();
    public boolean isEmpty();
    public boolean counterMaxed();
}
