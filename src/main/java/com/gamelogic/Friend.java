package com.gamelogic;

import com.rendering.Tile;
import org.newdawn.slick.opengl.Texture;

import static com.rendering.Clock.delta;
import static com.rendering.Creator.DrawQuadTex;

public class Friend {

    private int width, height;
    private float x, y, speed;
    private Texture texture;
    private boolean first = true;
    private Tile startTile;

    public Friend(Texture texture, Tile startTile, int width, int height, float speed) {

        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void draw(){
        DrawQuadTex(texture, x, y, width, height);
    }

    public void update(){
        if(first){
            first = false;
        } else {
            x += delta() * speed;
        }
    }

}
