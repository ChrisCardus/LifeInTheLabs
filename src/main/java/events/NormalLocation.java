package events;

/**
 * For managing the effects of entering a certain location as if it were an event
 * @author Olivia Breen
 */


public class NormalLocation implements Event{
	
	//locations: 1 Lecture, 2 Gym, 3 Home, 4 CS Building, 5 Guild
	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Location
	
	public int[][] Event1 = {
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{1, 1}
	};

	public int[][] Event2 = {
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{1, 1}
	};
	
	public int[][] Event3 = {
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{1, 1}
	};
	
	public int[][] Event4 = {
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{1, 1}
	};
	
	public int[][] Event5 = {
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{0, 0},
			{1, 1}
	};
	
	public int[][] GetEvent(int location) {
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

	
	


}