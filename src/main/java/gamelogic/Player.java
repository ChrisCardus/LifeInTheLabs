package gamelogic;

import graphics.Avatars;
import graphics.Room;

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
	public Room location;
	public Avatars avatar;
	private int energy;
	
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
