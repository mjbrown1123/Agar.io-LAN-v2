package server;

import java.awt.*;
import javax.swing.*;


	
public class GameFrame extends JPanel{
	
	
	public static void main(String[] args) {

		//jframe to contain the game
		JFrame frame = new JFrame("Agar.io LAN Client");
		
		//create a dimension object for the screen's dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//get the width and height of the screen
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		
		String os = System.getProperty("os.name");
		if(os.substring(0,3).equals("Mac")) {
			System.out.println("You are using a Mac!");
			height -= 100;
		}
		
		//create a new game object
		Game s = new Game(width, height);

		//add the JPanel to the frame and change the background 
		frame.add(s);		
		frame.setBackground(Color.black);
		frame.setSize((int)width, (int)height);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}
}
