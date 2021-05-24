package Testing;

import encodingControl.encodingFactory;
import encodingControl.encodingInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncoderTest {

    @Test
    public void testROT13(){
        encodingInterface rot13 = encodingFactory.createEncodingClass("rot13");
        String returnString = rot13.encode("TEST test");
        assertEquals(returnString,"GRFG grfg");

    }
    @Test
    public void testATBASH(){
        encodingInterface atbash = encodingFactory.createEncodingClass("atbash");
        String returnString = atbash.encode("TEST test");
        assertEquals(returnString,"GVHG gvhg");
    }
}
