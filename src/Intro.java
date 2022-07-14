import javax.sound.sampled.AudioSystem;
import java.io.File;
import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel implements Runnable{
	private JFrame window = new JFrame();
	private String imagePath = "images\\intro.jpg";
	private int wait = 2000;	//2 seconds
	private String audioFileName = "audio\\bg-music.wav";
	
	public Intro(){	//default constructor
		//Play audio clip as the scene starts
		playAudio();

		//Set screen size
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH,
				GameManager.SCREEN_HEIGHT));
		
		//Add this frame to the window and set it up
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);	//only if you want fullscreen
		
		//Open the scene
		window.setVisible(true);
	}
	
	public void playAudio() {
		try {
			File audioPath = new File(audioFileName);
			//We need java's audio input stream
			GameManager.astream = AudioSystem.getAudioInputStream(audioPath);

			//Reference audio clip class
			GameManager.aclip = AudioSystem.getClip();

			//Open the stream using the clip class
			GameManager.aclip.open(GameManager.astream);

			//Start the music
			GameManager.aclip.start();
		
		} //end of the try block
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(imagePath).getImage(),
				-450,0, null);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(wait);
			window.dispose();
			//TODO create Menu class and load here
			//test2
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
