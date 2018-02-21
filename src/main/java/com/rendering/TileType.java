package com.rendering;

public enum TileType {

    GreyTile("tile", false), CsBuilding("csbuilding", true), OldJoe("oldjoe", true), Library("library", true), AstonWebb("astonwebb", true), Players("players", true)
    , Snobs("snobs", true), Pryzm("pryzm", true), Guild("guild", true), Gym("newgym", true);

    String textureName;
    boolean interactable;

    TileType(String textureName, boolean interactable){
        this.textureName = textureName;
        this.interactable = interactable;
    }
}
