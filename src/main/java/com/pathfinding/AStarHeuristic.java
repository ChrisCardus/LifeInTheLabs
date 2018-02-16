package com.pathFinding;

public interface AStarHeuristic {

    public float getHeuristicCost(TileBasedMap map, MovingObject mover,int x, int y, int tx, int ty);
}
