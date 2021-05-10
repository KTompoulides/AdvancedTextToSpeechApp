import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class ttsBase {
    private static Voice voice;

    public static void tts(String inputText,int rate,int pitch,int volume){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        //Voice voice;//Creating object of Voice class
        voice = VoiceManager.getInstance().getVoice("kevin");//Getting voice
        if (voice != null) {
            voice.allocate();//Allocating Voice
        }
        try{
            voice.setRate(rate);//Setting the rate of the voice
            voice.setPitch(pitch);//Setting the Pitch of the voice
            voice.setVolume(volume);//Setting the volume of the voice
            voice.speak(inputText);//Calling speak() method
        }
        catch(Exception e){
            System.out.println("ERROR! \n" + e );

        }
    }
}
