package events;

/**
 * The interface Event is for creating a structure that we can create multiple in-game events from.
 * @author Olivia Breen
 */
public interface Event {
	
	Object[] Event0 = new Object[7];
	Object[] Event1 = new Object[7];
	Object[] Event2 = new Object[7];
	
	public Object[] GetEvent(int location);
}
