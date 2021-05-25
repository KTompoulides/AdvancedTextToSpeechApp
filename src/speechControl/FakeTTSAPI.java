package speechControl;

public class FakeTTSAPI implements  TextToSpeechAPI{
    private String stuffToPLay;
    private int volume;
    private int pitch;
    private int rate;

    //Αυτό είναι ένα fake API στην πραγματικότητα αυτό που κάνει είναι να impementάρει τις
    //μεθόδους του κανονικού API για το testing
    //όταν θα κάνεις το testing θα καλέσεις αυτήν εδώ την κλάσση
    //θα βάλεις σε όλα τα set μία τιμή πχ 50 και θα τεστάρεις αν τα get επιστρέφουν την ίδια
    //για το play θα τσεκάρεις αν κουπώνει το string υπάρχει έξτρα get μέθοδος δες τέρμα κάτω

    public FakeTTSAPI()
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

    public String getStuffToPLay(){ //νέα μέθοδος για να ελέγξουμε αν περνάει το string στην ttsPlay()

        return stuffToPLay;
    }
}
