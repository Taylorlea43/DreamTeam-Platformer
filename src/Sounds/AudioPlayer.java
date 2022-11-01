package Sounds;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer 
{
	protected Clip clip;
	protected AudioInputStream audioStream;
	protected String status;
	public String filepath;
	protected boolean loops;
	
	public AudioPlayer(boolean loop, String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		audioStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		this.filepath = filepath;
		loops = loop;
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if (loops)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void play()  
    { 
		clip.start();   
		status = "play"; 
    }

	public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException  
	{ 
		clip.stop(); 
		clip.close();
	}
	
	public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException  
	{ 
		audioStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile()); 
		clip.open(audioStream); 
		
		if(loops)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}