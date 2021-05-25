/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Factory that returns "encoding" objects as desired
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
