package Testing;

import encodingControl.EncodingFactory;
import encodingControl.EncodingInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncoderTest {

    @Test
    public void testROT13(){
        EncodingInterface rot13 = EncodingFactory.createEncodingClass("rot13");
        String returnString = rot13.encode("TEST test");
        assertEquals(returnString,"GRFG grfg");

    }
    @Test
    public void testATBASH(){
        EncodingInterface atbash = EncodingFactory.createEncodingClass("atbash");
        String returnString = atbash.encode("TEST test");
        assertEquals(returnString,"GVHG gvhg");
    }
}
