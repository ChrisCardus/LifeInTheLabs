package com.pathFinding;

public interface TileBasedMap {

    /**
     * @return number of tiles across the map (width)
     */

    public int getTilesWidth();

    /**
     * @return number of tiles up/down the map (height)
     */

    public int getTilesHeight();

    /**
     * @param x - x coordinate of tile visited
     * @param y - y coordinate of tile visited
     * @returns notification that the path finder has visited a particular location
     */

    public void pathFinderVisited(int x, int y);

    /**
     * @param mover - The mover that is potentially moving through a blocked tile
     * @param x - x coordinate of tile check
     * @param y - y coordinate of tile check
     * @return true if location is blocked
     */

    public boolean blocked(MovingObject mover, int x, int y);

    /**
     * @param mover - Mover moving across a tile
     * @param sx - x coordinate of starting location
     * @param sy - y coordinate of starting location
     * @param tx - x coordinate of target location
     * @param ty - y coordinate of target location
     * @return the cost of moving from starting tile to target tile
     */

    public float getCost(MovingObject mover, int sx, int sy, int tx, int ty);


}
