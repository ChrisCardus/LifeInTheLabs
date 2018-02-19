package com.rendering;

import static com.rendering.Creator.DrawQuadTex;

public class TileGrid {

    public Tile[][] map;

    public TileGrid(){
        map = new Tile[15][10];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.GreyTile);
            }
        }
    }

    public TileGrid(int[][] newMap){
        map = new Tile[15][10];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                switch (newMap[j][i]){
                    case 0:
                        map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.GreyTile);
                        break;

                    case 1:
                        map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.AstonWebb);
                        break;

                    case 2:
                        map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.CsBuilding);
                        break;

                    case 3:
                        map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.Library);
                        break;

                    case 4:
                        map[i][j] = new Tile(i *75, j *75, 75, 75, TileType.OldJoe);
                        break;
                }
            }
        }
    }

    public void Draw(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Tile tile = map[i][j];
                DrawQuadTex(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
            }
        }
    }

}