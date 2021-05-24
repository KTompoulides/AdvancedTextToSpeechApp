package speechControl;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter implements TextToSpeechAPI{

    private Voice voice;
    private VoiceManager voiceManager;

    public FreeTTSAdapter(){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin");
        voice.allocate();

    }
    @Override
    public void playTts(String textToPlay) {
        try{
            voice.speak(textToPlay);
        }catch (Exception e){
            System.out.println("freeTTS error possible API problem");
        }
    }

    @Override
    public void setVolume(int volume) {
        float actualVolume = (float) volume/100; //values are big numbers slider is max 100
        voice.setVolume(actualVolume);
    }

    @Override
    public void setPitch(int pitch) {
        voice.setPitch((float) pitch);

    }

    @Override
    public void setRate(int rate) {

        voice.setRate((float) rate);
    }

    @Override
    public int getVolume() {
        return (int) voice.getVolume()/100;
    }

    @Override
    public int getPitch() {
        return (int) voice.getPitch();
    }

    @Override
    public int getRate() {
        return (int) voice.getRate();
    }
}
