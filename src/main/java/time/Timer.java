package time;

public class Timer implements Runnable {

	private long startTime = System.currentTimeMillis();
	private long endTime = startTime + 600000;
	private long time = startTime;
	int test;
	
	
	public void run() {
		while(time < endTime) {
			time = System.currentTimeMillis();
			if(time % 1000 == 0) {
			    timeLeft((int)time);
            }
		}
		
		Day.startNewDay();
		this.reinitialise();
	}
	
	private void reinitialise() {
		System.out.println("Start a New Day!");
		System.out.println((time - startTime) / 1000.0);
		startTime = System.currentTimeMillis();
		endTime = startTime + 600000;
		time = startTime;
	}

	public int timeLeft(int time) {
        return time;
    }
}
