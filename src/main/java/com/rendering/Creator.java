package com.rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class Creator {

    public static final int WIDTH = 1280, HEIGHT = 704;

    public static void BeginSession(){
        Display.setTitle("Life In The Labs");
        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException e){
            e.printStackTrace();
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, WIDTH, HEIGHT, 0,1 , -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void DrawQuad(float x, float y, float width, float height){
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();
    }

    public static void DrawQuadTex(Texture texture, float x, float y, float width, float height){
        texture.bind();
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
        GL11.glEnd();
        GL11.glLoadIdentity();


    }

    public static Texture LoadTexture(String path, String fileType){
        Texture texture = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try{
            texture = TextureLoader.getTexture(fileType, in);
        } catch (IOException e){
            e.printStackTrace();
        }
        return texture;

    }


    public static Texture QuickLoad(String name) {
        Texture texture = null;
        texture = LoadTexture("/home/will-i-am/IdeaProjects/LifeInTheLabs/src/main/resources/" + name + ".png", "PNG");
        return texture;
    }


}
