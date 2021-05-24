package encodingControl;

import speechControl.FreeTTSAdapter;
import speechControl.TextToSpeechAPI;

public class encodingFactory {
    public static encodingInterface createEncodingClass(String name) {
        if (name.equals("atbash")) {
            return new encodeAtBash();
        }
        else if (name.equals(("rot13"))){
            return new encodeROT13();
        }
        return null;
    }

}
