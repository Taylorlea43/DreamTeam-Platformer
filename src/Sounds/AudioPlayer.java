package Sounds;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer 
{
	protected Clip clip;
	protected String status;
	protected String filepath;
	
	public AudioPlayer(boolean loop) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}