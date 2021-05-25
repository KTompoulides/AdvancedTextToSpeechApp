package speechControl;

public class TtsFactory {
    public static TextToSpeechAPI createTextToSpeechAPI(String name) {
        if (name.equals("FreeTTSAdapter")) {
            return new FreeTTSAdapter();
        }
        else if (name.equals("fakeTTSAPI")) {
            return new FakeTTSAPI();
        }
        return null;
    }
}
