package com.gamelogic;

import com.rendering.Tile;
import com.rendering.TileGrid;
import org.newdawn.slick.opengl.Texture;
import com.gamelogic.MultiplayerClient;

import static com.rendering.Clock.*;
import static com.rendering.Creator.drawQuadTex;
import static com.rendering.Creator.quickLoad;

/**
 * For storing player data and functionality.
 * @author Olivia Breen
 */

public class Player {

    private int width, height;
	private float x, y, speed;
	private int health;
	private int social;
	private int education;
	private int money;
	private float morality;
	private int energy;
	private Texture texture;
	private boolean first = true;
	static int userID;
	static String username;
    // startTile object is for the use of pathfinding and com.graphics and com.networking
	private Tile startTile;
	private TileGrid grid;
	private MultiplayerClient game;


	
	public Player(String username, int userID) {
		
		this.username = username;
		this.userID = userID;
		this.texture = quickLoad("player");
		this.x = grid.getTile(6, 6).getX();
		this.y = grid.getTile(6, 6).getY();
		this.width = 64;
		this.height = 64;
		this.speed = 0.5f;
		//Player.avatar = avatar;

		health = 50;
		// out of 100
		social = 50;
		// out of 100
		education = 0;
		// out of 100
		money = 1700;
		//no limit
		morality = 50;
		// out of 100
		energy = 100;
		// out of 100
		
		//Decide default position
		//position = new Tile(1,1);
	}

	public Player(String username, int userID, MultiplayerClient game) {
        this.username = username;
        this.userID = userID;
        this.texture = quickLoad("player");
        this.x = grid.getTile(6, 6).getX();
        this.y = grid.getTile(6, 6).getY();
        this.width = 64;
        this.height = 64;
        this.speed = 0.5f;
        //Player.avatar = avatar;

        health = 50;
        // out of 100
        social = 50;
        // out of 100
        education = 0;
        // out of 100
        money = 1700;
        //no limit
        morality = 50;
        // out of 100
        energy = 100;
        // out of 100

        //Decide default position
        //position = new Tile(1,1);

        this.game = game;
    }

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
		if(this.health > 100) {
			this.health = 100;
		}
		game.serverHealth(this.health);
	}

	public int getSocial() {
		return social;
	}
	
	public void setSocial(int social) {
		this.social = social;
		if(this.social > 100) {
			this.social = 100;
		}
		game.serverSocial(this.social);
	}
	
	public int getEducation() {
		return education;
	}
	
	public void setEducation(int education) {
		this.education = education;
		if(this.education > 100) {
			this.education = 100;
		}
		game.serverEducation(this.education);
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
		game.serverMoney(this.money);
	}
	
	public float getMorality() {
		return morality;
	}
	
	public void setMorality(float morality) {
		this.morality = morality;
		if(this.morality > 100) {
			this.morality = 100;
		}
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
		if(this.energy > 100) {
			this.energy = 100;
		}
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}



	public int getID() {
		return userID;
	}

	public void draw(){
	    drawQuadTex(texture, x, y, width, height);
    }

    public void update(){
	    if(first){
	        first = false;
        } else {
            x += getDelta() * speed;
        }
    }

}
