package gameGraphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;





public class Renderer {
		
		private static Frame frame; 	
		
		private static Panel panel;
		
	//	private static Canvas canvas;
		public static final String title = new String("Life In The Labs ");
		
		private static int canvasWidth = 0;
		private static int canvasHeight = 0;
		
		//the default sizes of the game
		private static final int GAME_HEIGHT=250;
		private static final int GAME_WIDTH = 400;
		
		//the actual sizes of the game
		private static  int gameWidth=0;
		private static  int gameHeight=0;
		
		static JLabel label = new JLabel("Welcome");
		static JButton button = new JButton("PLAY");
		
		
		
		private static void getBestSize(){
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();	//a toolkit that gives information about the screen
			Dimension screenSize = toolkit.getScreenSize();
			
			//creating a loop that will make the canvas bigger by multiples of the default game sizes until it cannot expand anymore
			boolean done = false;
			
				while(!done){
					canvasWidth +=GAME_WIDTH;
					canvasHeight +=GAME_HEIGHT;
				
						if(canvasWidth > screenSize.width || canvasHeight > screenSize.height){
							canvasWidth -=GAME_WIDTH;
							canvasHeight -=GAME_HEIGHT;
							done=true;
						}
				}
			
			int xDiff = screenSize.width - canvasWidth;		
			int yDiff = screenSize.height - canvasHeight;
			int factor = canvasWidth/GAME_WIDTH; 	
						//(Or we could make use of the heights, it does not matter) 
						//this factor will show us how many times we have to multiply the GAME_WIDTH to obtain the canvasWidth
			
			gameWidth = canvasWidth / factor + xDiff / factor;
			gameHeight = canvasHeight / factor + yDiff / factor;
			
			canvasWidth = gameWidth * factor;
			canvasHeight = gameHeight * factor;
		}
		
		private static void makeFullscreen(){
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = env.getDefaultScreenDevice();		//give access to com.graphics
			
			if(gd.isFullScreenSupported()){
				frame.setUndecorated(true);
				gd.setFullScreenWindow(frame);
			}
		}
	
		public static void init(){
			
				getBestSize();
				frame=new Frame();
				panel=new Panel();
				
					
				panel.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
				
				frame.add(panel);
				
			
			//	frame.setTitle(title);
			//	frame.getTitle();
				
				panel.add(label);
				panel.add(button);
			
				
				makeFullscreen();
				
				frame.pack();
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				
				
				
				frame.addWindowListener(new WindowAdapter () {
						public void windowClosing(WindowEvent e) {
							Game.quit();
						}
						
				});
				frame.setVisible(true);
				
			//	frame.addNotify(); //make it displayable
				
				startRendering();
				
				
	}
		
		private static void startRendering(){
			Thread thread = new Thread() {
				public void run(){
					GraphicsConfiguration gc = panel.getGraphicsConfiguration();
					
					/**We are using VolatileImage because it is hardware accelerated, so it will make the com.graphics much faster.
					 * The image is volatile because its contents could disappear at any moment.
					 */
					VolatileImage vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);
					while(true) {
						
						if(vImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {	
							
							/**If the method "validate()" finds out that the image is incompatible,
							 * we have to create that image again.
							 */
							vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);		
												
						}
						//Since the volatile image is smaller than the screen, it will be scaled up
						Graphics g = vImage.getGraphics();
						
						g.setColor(Color.black);
						g.fillRect(0, 0, gameWidth, gameHeight);
										
						//	g.setColor(Color.red);
					//	g.drawRect(10,10,100,100);	// and then change the default width and height
						 
						
						
						// Render stuff
						
						g.dispose();
						
						g = panel.getGraphics();
						g.drawImage(vImage, 0, 0, canvasWidth, canvasHeight, null);		//null->the observer
						
						g.dispose();
					}
				}
				
			};
			thread.setName("rendering Thread");
			thread.start();
		}
}
