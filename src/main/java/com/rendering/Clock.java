package com.rendering;

import org.lwjgl.Sys;

public class Clock {

    private  static boolean paused = false;
    public static long lastFrame, totalTime;
    public static float d = 1, multiplier = 1;

    public static long getTime(){
        return Sys.getTime()* 1000/ Sys.getTimerResolution();
    }

    public static float getDelta(){
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta * 0.01f;
    }

    public static float delta() {
        if (paused) {
            return 0;
        } else {
            return d * multiplier;
        }
    }

    public static float getTotalTime(){
        return totalTime;
    }

    public static float getMultiplier(){
        return multiplier;
    }

    public static void update(){
        d += getDelta();
        totalTime += d;
    }

    public static void changeMultiplier(int change){
        if (multiplier + change < 0 && multiplier + change > 5){

        } else {
            multiplier += change;
        }
    }

    public static void pause(){
        if(paused){
            paused = false;
        } else {
            paused = true;
        }
    }

}