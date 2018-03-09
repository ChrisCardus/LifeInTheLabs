package com.gamelogic;

import com.events.EventManager;
import com.rendering.Tile;
import com.rendering.TileGrid;
import com.rendering.TileType;

import org.lwjgl.input.Mouse;

/**
 * For controlling player movement and actions
 * @author Olivia Breen and William Walter
 */

public class PlayerController {

	private TileGrid grid;
	private Player player;
	
	
    public PlayerController(TileGrid grid, Player player){
        this.grid = grid;
        this.player = player;
    }

    public void update(){
        if (Mouse.isButtonDown(0)){
            int x = Mouse.getX();
            int y = Mouse.getY();
            Tile tile = grid.getTile(x, y);
            TileType type = tile.getType();
            int location = 0;
            if(type == TileType.CsBuilding) {
            	location = 4;
            }
            if(type == TileType.Guild) {
            	location = 5;
            }
            if(type == TileType.AstonWebb) {
            	location = 1;
            }
            if(type == TileType.Gym) {
            	location = 2;
            }
			EventManager.LocationEntered(player, location);
        }
    }
}
