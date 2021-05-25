package Testing;

import speechControl.TextToSpeechAPI;
import speechControl.TtsFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class speechControlTest {

	@Test
	public void setPitchTest() {

		TextToSpeechAPI tts = TtsFactory.createTextToSpeechAPI("fakeTTSAPI");
		tts.setPitch(60);
		//System.out.println(tts.getPitch());
		assertEquals(tts.getPitch(), 60);
	}
	
	@Test
	public void setRateTest() {

		TextToSpeechAPI tts = TtsFactory.createTextToSpeechAPI("fakeTTSAPI");
		tts.setRate(10);
		//System.out.println(tts.getRate());
		assertEquals(tts.getRate(), 10);
	}


}
