package gameGraphics;

public interface Window {
	
	public void setName(String name); 	//Set the name of the Game
	
	public void setResolution(int x, int y);	//Set the display resolution
	
	public void startRendering();	//Start the game window
	
	public void setWindowCallback(WindowCallback callback);	//Set the callback for the events 
	
	public boolean isKeyPressed(int keyCode);	//Check if a key is pressed; We are not actually calling for the key, but for its code(keyCode); It returns true/false depending if the key is pressed or not
}
