package events;

/**
 * There are two events classes for the two main types of events, location events and random events.
 * @author Olivia Breen
 */

public class LocationEvents {

	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Text, 8 = Location
	public Object[] Event0 = new Object[8];
	public Object[] Event1 = new Object[8];
	public Object[] Event2 = new Object[8];
	
	Object[] GetEvent(String location) {
		if(Event0[8] == location) {
			return Event0;
		}
		if(Event1[8] == location) {
			return Event1;
		}
		if(Event2[8] == location) {
			return Event2;
		}
		else {
			return null;
		}
		
	}
	
	
}
