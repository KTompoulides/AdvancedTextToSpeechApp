/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is a test class for the TTS API it checks the function of the API

package Testing;

import speechControl.TextToSpeechAPI;
import speechControl.TTSFactory;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpeechControlTest {
	
	@Test
	public void playTtsTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		assert tts != null;
		tts.playTts("Hey!!");
		assertEquals(tts.getStuffToPLay(), "Hey!!");
	}
	
	@Test
	public void setVolumeTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		assert tts != null;
		tts.setVolume(70);
		assertEquals(tts.getVolume(), 70);
	}

	@Test
	public void setPitchTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		assert tts != null;
		tts.setPitch(60);
		assertEquals(tts.getPitch(), 60);
	}
	
	@Test
	public void setRateTest() {

		TextToSpeechAPI tts = TTSFactory.createTextToSpeechAPI("fakeTTSApi");
		assert tts != null;
		tts.setRate(10);
		assertEquals(tts.getRate(), 10);
	}


}
