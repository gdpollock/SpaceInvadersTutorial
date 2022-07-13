import javax.sound.sampled.AudioSystem;
import java.io.File;
import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel implements Runnable{
	private JFrame window = new JFrame();
	private String imagePath = "images\\intro.jpg";
	private int wait = 2000;	//2 seconds
	
	public Intro(){	//default constructor
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH,
				GameManager.SCREEN_HEIGHT));
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
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
