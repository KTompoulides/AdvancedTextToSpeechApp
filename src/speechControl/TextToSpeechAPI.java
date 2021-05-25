/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is the TTS interface MUST be implemented by all TTS related classes

package speechControl;

public interface TextToSpeechAPI {

    void playTts(String string);

    void setVolume(int volume);

    void setPitch(int pitch);

    void setRate(int rate);

    int getVolume();

    int getPitch();

    int getRate();
    
    String getStuffToPLay();
}
