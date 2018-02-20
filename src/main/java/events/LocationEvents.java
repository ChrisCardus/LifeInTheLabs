package events;



/**
 * There are two events classes for the two main types of events, location events and random events.
 * @author Olivia Breen
 */

public class LocationEvents {
	//locations: 1 Lecture, 2 Gym, 3 Home, 4 CS Building, 5 Guild
	// Object[1] = Health, 2 = Social, 3 = Education, 4 = Money, 5 = Morality, 6 = Energy, 7 = Location

	public String[] EventString1 = {"You arrive at the Lecture only to find it has been cancelled! Do you either use the extra time to go home and take a nap, or go and finish some work in the labs since you're already on campus?", "Nap Time!", "Finish Work.", "The most satisfying nap of your life. You wake up feeling refreshed and ready to take on the world!", "You get some work done, but you're easily distracted when some of your friends come to join. Still, better than no work done!"};
	public String[] EventString2 = {"You're about to head into the gym when you realise you're starving! There's a vending machine nearby, but it's notoriously expensive. You could go home to get food, but that would waste precious gym time. What do you do?", "Head Home","Gym ASAP!","You pop home to your stash of energy bars and cheap ALDI lucozade. On your way back out again you bump into your housemate gearing up for a run and just decide to join them instead!","After a disappointingly small Paleo All-Natural Organic Protein Bar TM you head into the gym and smash your workout. Nice going!"};
	public String[] EventString3 = {"You're about to head into campus to get some work done in the labs, when your increasingly ill housemate calls out into the corridor asking you for your help. What do you do?", "Help Them Out.", "Leave for Labs!", "All they wanted was some warm soup and a fresh warm flannel. You leave for the labs afterwards feeling like a good person - but hope you haven't caught anything!", "You leave them for the labs and have a very productive afternoon. You're sure that they can take care of themselves…"};
	public String[] EventString4 = {"You're in the labs and working on an assignment. Your friend turns to you and asks for help. He doesn't want to cheat off you - just get some pointers - but you're worried it'll count as plagiarism. What do you do?", "Give Some Pointers", "Play it Safe.", "Your pointers aren't quite enough - he comes back for troubleshooting help a few times - but eventually you've both submitted and can finally go home.", "You tell him you can't explain it, and he should figure it out for himself. He'll probably be fine on his own…?"};
	public String[] EventString5 = {"You're working when suddenly you receive a notification saying the lecture times for Friday have been moved to this evening! You should be working then, but maybe you can ask your manager to let you off a little early? What do you do?", "Ask.", "Don't Ask.", "Your manager lets you go but seems a little disgruntled. On the other hand, the lecture is very interesting and seems vital to the next assignment.", "			You can always panopto it later. You stay at work and as your shift is about to end it gets super busy. You are offered an extra hours work for double pay since they're understaffed - You say yes!"};
	
	
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
	
	String[] GetEventString(int location) {
		return null;
		
	}
}

	

