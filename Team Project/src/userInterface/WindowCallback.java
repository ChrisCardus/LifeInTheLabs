package userInterface;

public interface WindowCallback {
	
	public void init();	//The game receives notifications saying that it should initialise the needed resources (including spirtes)
	
	public void frameRendering();	//A notification that the display is rendered; Here we should also update the game logics
	
	public void windowClosed();	//A notification that the window closed
	
	
}
