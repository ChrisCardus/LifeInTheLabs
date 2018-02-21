package ui;

import java.util.ArrayList;
import static com.rendering.Creator.*;

public class UserInterface {
	
	private ArrayList<Button> buttonList;
	
	public UserInterface(){
		buttonList = new ArrayList<Button>();
	}

	public void addButton(String name, String textureName, int x, int y){
		buttonList.add( new Button( name, QuickLoad(textureName), x, y));
	}
	
	

	public void draw() {
		
		for (Button b: buttonList) {
			
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}

	
}
