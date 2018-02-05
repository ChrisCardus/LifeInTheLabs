package userInterface;

import java.io.IOException;

import javax.swing.*;


public class GameBoard {
	public static void main (String[] args) throws IOException{
		JFrame frame = new JFrame("Life In The Labs");
		frame.setContentPane(new Panel()); // we set the Panel as the JFrame's content and as the content pane
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the user is able to click the exit window icon for the app window to close
		frame.setResizable(false); //the frame cannot be resizable by the user; true/false?
		frame.pack(); //this method sizes the frame so that all its components fit in
		frame.setLocationRelativeTo(null); //the parameter is being set to null therefore the frame will be set in the center of the screen
		frame.setVisible(true);
		
		
	}

}
