package com.pathFinding;

public class ClosestHeuristic implements  AStarHeuristic {

    public float getHeuristicCost(TileBasedMap map, MovingObject mover, int x, int y, int tx, int ty){
        float dx = tx - x;
        float dy = ty - y;

        float result = (float) (Math.sqrt((dx*dx)+(dy*dy)));

        return result;
    }

}
