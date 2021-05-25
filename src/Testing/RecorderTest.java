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

    public void clearRecordingTest(){

    }

    public void getActionToRepeatTest(){

    }
}
