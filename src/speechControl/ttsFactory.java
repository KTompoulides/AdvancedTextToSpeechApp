package speechControl;

public class ttsFactory {
    public static TextToSpeechAPI createTextToSpeechAPI(String name) {
        if (name.equals("FreeTTSAdapter")) {
            return new FreeTTSAdapter();
        }else if(name.equals("fakeTTSApi")) {
        	return new fakeTTSApi();
        }
        return null;
    }
}
