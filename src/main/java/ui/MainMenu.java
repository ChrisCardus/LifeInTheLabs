package ui;


import org.newdawn.slick.opengl.Texture;
import static com.rendering.Creator.*;

public class MainMenu {
	
	
	private Texture background;
	private UserInterface menuUI;
	
	public  MainMenu(){
		background = QuickLoad("mainmenu");
		menuUI = new UserInterface();
		
		//menuUI.addButton("Single player", "singleplayer", WIDTH/2 - 128 , (int)( HEIGHT*0.45f));
		//	menuUI.addButton("Join game", "joinGame_button", WIDTH/2 - 128 , (int)( HEIGHT*0.55f));
		//	menuUI.addButton("Host game", "hostGame_button", WIDTH/2 - 128 , (int)( HEIGHT*0.65f));
		//menuUI.addButton("Exit", "exit_button", WIDTH/2 - 128 , (int)( HEIGHT*0.45f));
	}
	
	public void update() {
		DrawQuadTex(background, 0, 0, 2048, 1024);
		menuUI.draw();
	}


}
