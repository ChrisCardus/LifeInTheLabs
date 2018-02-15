package com.rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Creator {

    public static final int WIDTH = 1280, HEIGHT = 960;

    public static void BeginSession(){
        Display.setTitle("Life In The Labs");
        try{
            Display.setDisplayMode(new DisplayMode(1280, 960));
            Display.create();
        } catch (LWJGLException e){
            e.printStackTrace();
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, WIDTH, 0, HEIGHT,1 , -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public static void DrawQuad(float x, float y, float width, float height){
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();
    }

    public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
        tex.bind();
        GL11.glTranslatef(x,y,0);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(0,0);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(width,0);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(width,height);
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(0,height);
        GL11.glLoadIdentity();
        GL11.glEnd();

    }
}
