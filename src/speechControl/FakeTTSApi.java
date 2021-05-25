/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is a fake API that simply implements TextToSpeechAPI for testing purposes

package speechControl;

public class FakeTTSApi implements  TextToSpeechAPI{
    private String stuffToPLay;
    private int volume;
    private int pitch;
    private int rate;

    
    public FakeTTSApi()
    {
        stuffToPLay = "";
        volume = 100;
        pitch = 100;
        rate = 100;
    }

    @Override
    public void playTts(String string) {
        stuffToPLay += string;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    @Override
    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public int getPitch() {
        return pitch;
    }

    @Override
    public int getRate() {
        return rate;
    }

    public String getStuffToPLay(){ 
        return stuffToPLay;
    }
}
