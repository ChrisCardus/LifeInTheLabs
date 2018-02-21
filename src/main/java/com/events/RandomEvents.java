package com.events;


/**
 * There are two com.events classes for the two main types of com.events, location com.events and random com.events.
 * @author Olivia Breen
 */

public class RandomEvents implements Event{
	
	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Likelihood

	public int[][] Event1 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{10, 10, 10}
	};
	
	public int[][] Event2 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{15, 15, 15}
	};
	
	public int[][] Event3 = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{30, 30, 30}
	};
	
	
	
	public Object[] GetEvent(int location) {
		return null;
	}

	
	
}
