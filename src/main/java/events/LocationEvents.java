package events;



/**
 * There are two events classes for the two main types of events, location events and random events.
 * @author Olivia Breen
 */

public class LocationEvents {
	//locations: 1 Lecture, 2 Gym, 3 Home, 4 CS Building
	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Location

	public int[][] Event0 = {
			{0, 10, -5},
			{0, 0, 5},
			{0, -5, 5},
			{0, 0, 0},
			{0, 0, 0},
			{0, -5, -10},
			{1, 1, 1}
	};
	
	public int[][] Event1 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{2, 2, 2}
	};
	
	public int[][] Event2 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{3, 3, 3}
	};
	
	public int[][] Event3 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{4, 4, 4}
	};

	
	
	Object[] GetEvent(int location) {
		if(Event0[1][8] == location) {
			return Event0;
		}
		if(Event1[1][8] == location) {
			return Event1;
		}
		if(Event2[1][8] == location) {
			return Event2;
		}
		if(Event3[1][8] == location) {
			return Event3;
		}
		else {
			return null;
		}
		
	}
}

	

