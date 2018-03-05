package com.rendering;


import org.lwjgl.Sys;

public class Clock {

    private  static boolean paused = false;
    public static long lastFrame, totalTime;
    public static float d = 1;

    public static long getTime(){
        return Sys.getTime()* 1000/ Sys.getTimerResolution();
    }

    public static float getDelta(){
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta * 0.3f;
    }

    public static float getTotalTime(){
        return totalTime;
    }


    public static void update(){
        d += getDelta();
        totalTime += d;
    }

    public static void pause(){
        if(paused){
            paused = false;
        } else {
            paused = true;
        }
    }

}
