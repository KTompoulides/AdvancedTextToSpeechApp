package actionRepeater;


public class RecorderFactory {
    public static RecorderInterface createRecorder(String name) {
        if (name.equals("action")) {
            return new ActionRecorder();
        }
        return null;
    }
}
