package speechControl;

//import freeTTS libraries
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public interface TextToSpeechAPI {

    public void playTts(String string);

    public void setVolume(int volume);

    public void setPitch(int pitch);

    public void setRate(int rate);

    public int getVolume();

    public int getPitch();

    public int getRate();
}
