package com.rendering;

import static com.rendering.Creator.DrawQuadTex;

import com.pathFinding.MovingObject;

public class TileGrid implements com.pathFinding.TileBasedMap{

    public Tile[][] map;
    public int WIDTH = 15;
    public int HEIGHT = 11;
    private boolean[][] visited = new boolean[WIDTH][HEIGHT];

    public TileGrid(){
        map = new Tile[WIDTH][HEIGHT];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.GreyTile);
            }
        }
    }

    public TileGrid(int[][] newMap){
        map = new Tile[WIDTH][HEIGHT];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                switch (newMap[j][i]){
                    case 0:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.GreyTile);
                        break;

                    case 1:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.AstonWebb);
                        break;

                    case 2:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.CsBuilding);
                        break;

                    case 3:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Library);
                        break;

                    case 4:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.OldJoe);
                        break;

                    case 5:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Guild);
                        break;

                    case 6:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Snobs);
                        break;

                    case 7:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Players);
                        break;

                    case 8:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Pryzm);
                        break;

                    case 9:
                        map[i][j] = new Tile(i *64, j *64, 64, 64, TileType.Gym);
                        break;

                }
            }
        }
    }

    public void setTile(int xCoord, int yCoord,TileType type){
        map[xCoord][yCoord] = new Tile(xCoord*64,yCoord*64,64,64,type);
    }

    public Tile getTile(int xCoord,int yCoord) {
        return map[xCoord][yCoord];
    }

    public void Draw(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Tile tile = map[i][j];
                DrawQuadTex(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
            }
        }
    }

    public int getTilesWidth() {
        return WIDTH;

    }

    public int getTilesHeight() {
        return HEIGHT;
    }

    public void pathFinderVisited(int x, int y) {
        visited[x][y] = true;


    }

	@Override
	public boolean blocked(com.pathFinding.MovingObject mover, int x, int y) {
        if(getTile(x,y).getX() != 0 && getTile(x,y).getY() != 0){
            return true;
        }

        return true;
	}

	@Override
	public float getCost(com.pathFinding.MovingObject mover, int sx, int sy, int tx, int ty) {
        return (float) Math.sqrt(Math.pow((tx - sx), 2) + Math.pow((ty - sy), 2));
	}
}