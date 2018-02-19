package applet;

import javax.swing.*;
import java.awt.*;

public class GameApplet  extends JApplet{
	
	public static final long serialVersionUID=1L;
	private Panel panel;
	Image myImage;
	
	public void init(){
		
		//the init() method is invoked by the container at the begining
		Container contentPane = getContentPane(); //the content pane is provided by the container, where we add components in order 
		contentPane.setLayout(new BorderLayout()); //(LayoutManager.Center)
		panel = new Panel(); 
		contentPane.add(panel);
		this.setSize(Panel.WIDTH,Panel.HEIGHT); // set the width and the height of the applet to match to the ones of the panel
		
		
	}
	
}
