/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is a test class for the recording system it checks if actions are recorded and cleared from memory successfully

package Testing;
import actionRepeater.RecorderFactory;
import actionRepeater.RecorderInterface;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;

public class RecorderTest {

    @Test
    public void actionRecordTest(){
        RecorderInterface recorder = RecorderFactory.createRecorder("action");
        Object dummyObject = new Object();
        recorder.addAction(dummyObject);
        assertEquals(dummyObject,recorder.getNextAction());

    }

    @Test
    public void clearRecordingTest(){
        RecorderInterface recorder = RecorderFactory.createRecorder("action");
        Object dummyObject = new Object();
        recorder.addAction(dummyObject);
        recorder.clearActions();
        assertEquals(0,recorder.getActionsList().size());


    }
}
