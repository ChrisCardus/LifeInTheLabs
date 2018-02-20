package events;

import java.util.Random;
import gamelogic.Player;
import events.LocationEvents;

/**
 * The class EventManager is for calling event arrays and displaying them in the game
 * @author Olivia Breen
 */

public class EventManager {
	Random random = new Random();
	private LocationEvents locationevents;
	
	//this random percentage will be used to manage event probabilities
	
	//to be called on when a location is entered
	boolean LocationEntered(Player player, int location) {
		int n = random.nextInt(101);
		if (n < 40) {
			int[][] event = locationevents.GetEvent(location);
			RunEvent(event);
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	void RunEvent(Object[] event) {
		// Change attributes, signal to UI to display text box
		// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Text, 8 = Location
		String text = (String) event[7];
		// UI method that takes String as a parameter, splits String into 3 and displays event
		
	}
	void UpdateAttributes(int[][] event, int choice, Player player) {	

		int healthchange = event[choice][1];
		int socialchange = event[choice][2];
		int educationchange = event[choice][3];
		int moneychange = event[choice][4];
		float moralitychange = event[choice][5];
		int energychange = event[choice][6];
		
		int health = player.getHealth();
		int social = player.getSocial();
		int education = player.getEducation();
		int money = player.getMoney();
		float morality = player.getMorality();
		int energy = player.getEnergy();
		
		health = health + healthchange;
		social = social + socialchange;
		education = education + educationchange;
		money = money + moneychange;
		morality = morality + moralitychange;
		energy = energy + energychange;
		
		player.setHealth(health);
		player.setSocial(social);
		player.setEducation(education);
		player.setMoney(money);
		player.setMorality(morality);
		player.setEnergy(energy);
		
	}

}
