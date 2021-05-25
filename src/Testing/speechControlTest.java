package Testing;

import speechControl.TextToSpeechAPI;
import speechControl.ttsFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class speechControlTest {

	@Test
	public void setPitchTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("FreeTTSAdapter");
		tts.setPitch(60);
		//System.out.println(tts.getPitch());
		assertEquals(tts.getPitch(), 60);
	}
	
	@Test
	public void setRateTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("FreeTTSAdapter");
		tts.setRate(10);
		System.out.println(tts.getRate());
		//assertEquals(tts.getRate(), 70);
	}


}
