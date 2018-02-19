package userInterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class AnotherMenu {
	private static void createWindow ()  { 
		JFrame frame = new JFrame();	//create a new frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//the application terminates when the window is closed
		//frame.setBounds(10, 10, 300, 100);
		
		JLabel label = new JLabel();
		//textLabel.setPrefferedSize(newDimension(400, 200));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		
	//	JMenuBar menuBar;
	//	JMenu menu, subMenu;
	//	JRadioButtonMenuItem radioButton;
   //JCheckBoxMenuItem checkBox;
		
		JMenuBar menuBar = new JMenuBar();
		
		//there will be more menus: 
		
		JMenu menu1 = new JMenu("File");
		menu1.setMnemonic(KeyEvent.VK_F);
		JMenu menu2 = new JMenu("Options");
		menu2.setMnemonic(KeyEvent.VK_O);
		JMenu menu3 = new JMenu("Help");
		menu3.setMnemonic(KeyEvent.VK_H);
				
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		//later i will add images for the items using "new ImageIcon("")"
		JMenuItem menuItem1 = new JMenuItem("New Game");	//-> singleplayer(game mode-competitive/..), multiplayer	, ?offline
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem menuItem2 = new JMenuItem("Load");  //-> choose from saved files
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		JMenuItem menuItem3 = new JMenuItem("Exit");
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
				
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		
		JMenuItem menuItem4 = new JMenuItem("Pause Game");
		JMenuItem menuItem5 = new JMenuItem("Resume Game");
		JMenuItem menuItem6 = new JMenuItem("Customize your character");
		JMenuItem menuItem7 = new JMenuItem("");

		

		
		
				
		frame.getContentPane().add(menuBar, BorderLayout.PAGE_START);
	
		
		
		//JMenuItem menuItem = new JMenuItem("Menu");
		
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		createWindow();
	}
}
