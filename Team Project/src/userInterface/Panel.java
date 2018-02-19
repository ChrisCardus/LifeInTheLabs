package userInterface;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
		
	private static final long serialVersionUID = 1L; 
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	Image myImage;
	
	public Panel(){
		super(); // when an object overrides its superclass method
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); //set the preferred size of the component
		setFocusable(true); //indicates that this component is focusable
		requestFocusInWindow(); // the component gets the input focus		
				
	}

	private static void main(String[] args){}
	
//	private void init() throws IOException {
	
     
	//}
		
	

	public void paintComponent(Graphics graphics){
		
		Font myFont = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		graphics.setFont(myFont);
		graphics.setColor(new Color(153,0,76));
		
		//graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		super.paintComponent(graphics);
		//graphics.drawString("Life In The Labs", 320,240); 
		
		if (myImage!=null) { 
			graphics.drawImage(myImage, 0, 0, null);
		}	
		
		FontMetrics metrics = graphics.getFontMetrics();
		Rectangle2D stringRect = metrics.getStringBounds("Life In The Labs", graphics); //get the rectangular bounds of the game name
		
		//calculate the center of the screen
		int xAxis = WIDTH / 2;
		int yAxis = HEIGHT / 2;
		
		//calculate the starting point for the centered game name
		int stringX = xAxis - (int)(stringRect.getWidth()/2);
		int stringY = yAxis + (int)(stringRect.getHeight()/2);
		
		graphics.drawString("Life In The Labs", stringX, stringY); // draw centered  game name in the chosen colour	
		//graphics.drawRect(stringX,stringY , (int)(stringRect.getWidth()),(int)( stringRect.getHeight()));
		
		
		
	}
	
	
	
		
	
	
	
	

}
