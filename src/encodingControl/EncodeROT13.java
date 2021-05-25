package encodingControl;

public class EncodeROT13 implements EncodingInterface {
    @Override
    public String encode(String initialMsg) {
        String encodedMsg = ""; //initialize output string

        for (int i = 0; i < initialMsg.length(); i++) {
            char c = initialMsg.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            encodedMsg += c;
        }

        return encodedMsg;
    }
}
