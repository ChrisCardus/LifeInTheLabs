package com.rendering;

public enum TileType {

    GreyTile("greyTile", true), CsBuilding("csbuilding", false), OldJoe("oldjoe", false), Library("library", false), AstonWebb("astonwebb", false);

    String textureName;
    boolean buildable;

    TileType(String textureName, boolean buildable){
        this.textureName = textureName;
        this.buildable = buildable;
    }
}
