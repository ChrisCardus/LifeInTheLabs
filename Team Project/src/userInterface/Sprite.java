package userInterface;

// Animations (without state information) which are displayed. With this we can use the same animation in different places,without copying the image multiple times

public interface Sprite {
	
	public int getWidth();	//We get the width of the sprite in pixels
	
	public int getHeight();	//We get the height of the sprite in pixels
	
	public void draw(int x, int y);	//Draw the sprite where indicated

}
