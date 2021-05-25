package encodingControl;

public class EncodingFactory {
    public static EncodingInterface createEncodingClass(String name) {
        if (name.equals("atbash")) {
            return new EncodeAtBash();
        }
        else if (name.equals(("rot13"))){
            return new EncodeROT13();
        }
        return null;
    }

}
