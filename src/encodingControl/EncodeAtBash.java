/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//A simple ATBASH text encoder

package encodingControl;

import java.util.ArrayList;

public class EncodeAtBash implements EncodingInterface {
    @Override
    public String encode(String initialMsg) {

        ArrayList<Character> al = new ArrayList<>();
        ArrayList<Character> alc = new ArrayList<>();
        String encodedMsg = "";

        for (char c = 'a'; c <= 'z'; c++) {
            al.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            alc.add(c);
        }
        char oc;

        for (int i = 0; i < initialMsg.length(); i++) {
            char c = initialMsg.charAt(i);
            if (al.contains(c)) {
                oc = al.get(25 - al.indexOf(c));
            }
            else if (alc.contains(c)){
                oc = alc.get(25 - alc.indexOf(c));
            }
            else {
                oc = c;
            }
            encodedMsg += oc;


        }

        return encodedMsg;
    }
}
