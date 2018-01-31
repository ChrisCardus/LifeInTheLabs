package pathFinding;

public interface PathFinder {

    public Path findPath(MovingObject mover, int sx, int sy, int tx, int ty);
    /** Finds a path from starting location (sx, sy) to target location (tx, ty) where x and y are the coordinates of that particular location
     * @param mover which is the object moving along the path
     */
}
