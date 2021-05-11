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

    public String getEncryptedText(){
        return encodedMsg;
    }

    public void setTextToEncrypt(String textInput){
        this.textInput = textInput;

    }
}
