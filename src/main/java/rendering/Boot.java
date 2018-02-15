package com.rendering;

import org.lwjgl.opengl.Display;

import static com.rendering.Creator.BeginSession;

public class Boot {

    public Boot(){

        BeginSession();

        while ((!Display.isCloseRequested())){
            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void main(String [] args){
        new Boot();
    }
}
