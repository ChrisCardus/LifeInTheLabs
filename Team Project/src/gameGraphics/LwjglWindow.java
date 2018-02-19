package gameGraphics;

import java.awt.event.KeyEvent;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class LwjglWindow implements Window {
	
	private WindowCallback callback; 
	
	private boolean gameRunning = true; //Return true if the game loop is looping
	
	private int height;
	
	private int width;
	
	private TextureLoader textureLoader;	//The loader converts images into OpenGL textures
	
	private String title;
	
	public LwjglWindow(){
		//A new game window that will use OpenGL to render the game
	}
		
		TextureLoader getTextureLoader(){
			return textureLoader;
		}
		
		public void setName(String title){
			this.title = title;
			if(Display.isCreated()){
				Display.setTitle(title);
			}
		}
		
		public boolean setDisplayMode(){				//sets the display mode for fullscreen mode
			try{
				DisplayMode[] dm = org.lwjgl.util.Display.getAvailableDisplayModes(width, height, -1, -1, -1, -1, 60, 60);
				org.lwjgl.util.Display.setDisplayMode(dm,new String[] {
						"width=" +width,
						"height=" +height,
						"freq=" +60,
						"bpp=" 
										+org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()});
						return true;
				}  catch (Exception e){
					e.printStackTrace();
					System.out.println("Unable to enter fullscreen, continuing in window mode");
					}
			return false;
		}
	
	
	

	@Override
	public void setResolution(int x, int y) {
		width=x;
		height=y;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startRendering() {
		try{
			setDisplayMode();
			Display.create();
			
			Mouse.setGrabbed(true); 
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);		//Enable 2D textures
		
			GL11.glDisable(GL11.GL_DEPTH_TEST); 	//Disable depth test because we use 2D graphics
			
			GL11.glMatrixMode(GL11.GL_PROJECTION); 	
			GL11.glLoadIdentity();
			
			GL11.glOrtho(0 , width, height, 0, -1, 1);
			
			textureLoader = new TextureLoader();
			
			if(callback!=null) {
				callback.init();
			}
					
		} catch (LWJGLException le){
			 callback.windowClosed();
		}
		
		gameLoop();
		// TODO Auto-generated method stub
		
	}
	
	private void gameLoop(){
		while(gameRunning){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			
			if(callback !=null){
				callback.frameRendering();
				
				Display.update();
				
				if(Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
					gameRunning = false;
					Display.destroy();
					callback.windowClosed();
				}
			}
		}
	}
	
	

	@Override
	public void setWindowCallback(WindowCallback callback) {
		
		this.callback = callback;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isKeyPressed(int keyCode) {
		switch(keyCode){
		case KeyEvent.VK_SPACE: keyCode = Keyboard.KEY_SPACE;
		break;
		case KeyEvent.VK_LEFT: keyCode = Keyboard.KEY_LEFT;
		break;
		case KeyEvent.VK_RIGHT:keyCode = Keyboard.KEY_RIGHT;
		break;
		}
		return org.lwjgl.input.Keyboard.isKeyDown(keyCode);
		// TODO Auto-generated method stub
		
	}
	
	
}
