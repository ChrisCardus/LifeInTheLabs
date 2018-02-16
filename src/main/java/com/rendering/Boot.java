package com.rendering;

import org.lwjgl.opengl.Display;

import static com.rendering.Creator.*;

public class Boot {

    public Boot(){

        BeginSession();

        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        TileGrid grid = new TileGrid(map);

        Tile greyTile = new Tile(0, 0, 75, 75, TileType.GreyTile);
        Tile csBuilding = new Tile(150, 150, 75, 75, TileType.CsBuilding);
        Tile aston = new Tile(225, 225, 75, 75, TileType.AstonWebb);
        Tile oldJoe = new Tile(300, 300, 75, 75, TileType.OldJoe);
        Tile library = new Tile(375, 375, 75, 75, TileType.Library);

        while ((!Display.isCloseRequested())){

            grid.Draw();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void main(String [] args){
        new Boot();
    }
}
