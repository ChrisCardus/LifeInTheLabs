package events;



/**
 * There are two events classes for the two main types of events, location events and random events.
 * @author Olivia Breen
 */

public class LocationEvents {
	//locations: 1 Lecture, 2 Gym, 3 Home, 4 CS Building, 5 Guild
	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Location

	public String[] EventString1 = {"You arrive at the Lecture only to find it has been cancelled! Do you either use the extra time to go home and take a nap, or go and finish some work in the labs since you're already on campus?", "Nap Time!", "Finish Work.", "The most satisfying nap of your life. You wake up feeling refreshed and ready to take on the world!", "You get some work done, but you're easily distracted when some of your friends come to join. Still, better than no work done!"};
	public String[] EventString2 = {};
	public String[] EventString3 = {};
	public String[] EventString4 = {};
	public String[] EventString5 = {};
	
	
	public int[][] Event1 = {
			{0, 10, -5},
			{0, 0, 5},
			{0, -5, 5},
			{0, 0, 0},
			{0, 0, 0},
			{0, -3, -5},
			{1, 1, 1}
	};
	
	public int[][] Event2 = {
			{0, 5, 10},
			{0, 5, 0},
			{0, 0, 0},
			{0, 0, -50},
			{0, 0, 0},
			{0, -3, -3},
			{2, 2, 2}
	};
	
	public int[][] Event3 = {
			{0, -5, 0},
			{0, 10, -5},
			{0, 5, 15},
			{0, 0, 0},
			{0, 10, -5},
			{0, -3, -3},
			{3, 3, 3}
	};
	
	public int[][] Event4 = {
			{0, 0, 0},
			{0, 10, -5},
			{0, 0, 5},
			{0, 0, 0},
			{0, 10, -5},
			{0, -5, -3},
			{4, 4, 4}
	};
	
	public int[][] Event5 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 10},
			{0, 250, 100},
			{0, 0, 0},
			{0, -5, -3},
			{5, 5, 5}
	};

	
	
	int[][] GetEvent(int location) {
		if(Event1[1][8] == location) {
			return Event1;
		}
		if(Event2[1][8] == location) {
			return Event2;
		}
		if(Event3[1][8] == location) {
			return Event3;
		}
		if(Event4[1][8] == location) {
			return Event4;
		}
		if(Event5[1][8] == location) {
			return Event5;
		}
		else {
			return null;
		}
		
	}
	
	String[] GetEventString(int location) {
		return null;
		
	}
}

	

