package gamelogic;

import graphics.Avatars;

/**
 * For storing player data and functionality.
 * @author Olivia Breen
 */

public class Player {
	
	private int health;
	private int social;
	private int education;
	private int money;
	private float morality;
	private int energy;
	// the position variable is for the use of pathfinding and graphics and networking
	public int position;
	static public Avatars avatar;
	static int userID;
	static String username;
	
	
	public Player(String username, int userID, Avatars avatar) {
		
		Player.username = username;
		Player.userID = userID;
		Player.avatar = avatar;
		
		health = 50;
		social = 50;
		education = 0;
		money = 1000;
		morality = 50;
		energy = 100;
		
		//create default position
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getSocial() {
		return social;
	}
	
	public void setSocial(int social) {
		this.social = social;
	}
	
	public int getEducation() {
		return education;
	}
	
	public void setEducation(int education) {
		this.education = education;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public float getMorality() {
		return morality;
	}
	
	public void setMorality(float morality) {
		this.morality = morality;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
	

}
