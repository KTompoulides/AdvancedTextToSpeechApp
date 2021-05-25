package Testing;

import speechControl.TextToSpeechAPI;
import speechControl.ttsFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class speechControlTest {
	
	@Test
	public void playTtsTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.playTts("Hey!!");
		System.out.println(tts.getStuffToPLay());
		//assertEquals(tts.getRate(), 70);
	}
	
	@Test
	public void setVolumeTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setVolume(70);
		//System.out.println(tts.getRate());
		assertEquals(tts.getVolume(), 70);
	}

	@Test
	public void setPitchTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setPitch(60);
		//System.out.println(tts.getPitch());
		assertEquals(tts.getPitch(), 60);
	}
	
	@Test
	public void setRateTest() {

		TextToSpeechAPI tts = ttsFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setRate(10);
		//System.out.println(tts.getRate());
		assertEquals(tts.getRate(), 10);
	}


}
