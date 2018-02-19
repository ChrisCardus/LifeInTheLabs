package com.rendering;

import org.newdawn.slick.opengl.Texture;

import static com.rendering.Creator.*;

public class Tile {

    private float x, y, width, height;
    private TileType type;
    private Texture texture;

    public Tile(float x, float y, float width, float height, TileType type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = QuickLoad(type.textureName);

    }

    public void Draw(){
        DrawQuadTex(texture, x, y, width, height);
    }


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {

        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public TileType getType() {
        return type;
    }

    public Texture getTexture() {
        return texture;
    }



}
