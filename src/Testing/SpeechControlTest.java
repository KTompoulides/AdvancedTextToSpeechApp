package Testing;

import speechControl.TextToSpeechAPI;
import speechControl.TTSFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpeechControlTest {
	
	@Test
	public void playTtsTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.playTts("Hey!!");
		assertEquals(tts.getStuffToPLay(), "Hey!!");
	}
	
	@Test
	public void setVolumeTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setVolume(70);
		assertEquals(tts.getVolume(), 70);
	}

	@Test
	public void setPitchTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setPitch(60);
		assertEquals(tts.getPitch(), 60);
	}
	
	@Test
	public void setRateTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		tts.setRate(10);
		assertEquals(tts.getRate(), 10);
	}


}
