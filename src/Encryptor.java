import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Encryptor {
    private String textInput;
    private String encodedMsg;


    public  Encryptor(String textInput){
        this.textInput=textInput;
        encodedMsg = "";


    }

    public Encryptor(){
        encodedMsg = "";
    }

    public void encryptROT13(){
        String initialMsg = textInput;
        for (int i = 0; i < initialMsg.length(); i++) {
            char c = initialMsg.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            encodedMsg += c;
        }

    }

    public void encryptAtbash() {
        ArrayList<Character> al = new ArrayList<Character>();
        ArrayList<Character> alc = new ArrayList<Character>();
        //encodedMsg ="";
        for (char c = 'a'; c <= 'z'; c++) {
            al.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            alc.add(c);
        }
        char oc = ' ';

        String initialMsg = textInput;
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
    }

    public String getEncryptedText(){
        return encodedMsg;
    }

    public void setTextToEncrypt(String textInput){
        this.textInput = textInput;

    }
}
