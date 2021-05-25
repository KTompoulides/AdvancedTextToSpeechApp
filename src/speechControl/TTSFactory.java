/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is the TTS factory it returns the desired TTS API

package speechControl;

public class TTSFactory {
    public static TextToSpeechAPI createTextToSpeechAPI(String name) {
        if (name.equals("FreeTTSAdapter")) {
            return new FreeTTSAdapter();
        }else if(name.equals("fakeTTSApi")) {
        	return new FakeTTSApi();
        }
        return null;
    }
}
