/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Factory that returns "Recorder" objects as desired
package actionRepeater;


public class RecorderFactory {
    public static RecorderInterface createRecorder(String name) { //single recorder implemented more could be implemented
        if (name.equals("action")) {
            return new ActionRecorder();
        }
        return null;
    }
}
