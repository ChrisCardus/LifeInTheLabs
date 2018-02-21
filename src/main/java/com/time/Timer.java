package com.time;

public class Timer implements Runnable {

	private long startTime = System.currentTimeMillis();
	private long endTime = startTime + 600000;
	private long time = startTime;
	int test;
	int seconds;
	
	
	public void run() {
		while(time < endTime) {
			time = System.currentTimeMillis();
			if(time % 1000 == 0) {
			    if(seconds != (int)(endTime - time) / 1000) {
                    seconds = (int)(endTime - time) / 1000;
                    timeLeft(seconds);
                }
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
