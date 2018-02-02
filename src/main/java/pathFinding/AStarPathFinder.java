package pathFinding;
import javafx.collections.transformation.SortedList;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Collections;

public class AStarPathFinder implements PathFinder{

    private ArrayList closed = new ArrayList();

    private SortedList open = new SortedList();

    private TileBasedMap map;

    private int maxSearchDistance;

    private Node[][] nodes;

    private boolean allowDiagonalMovt;

    private AStarHeuristic heuristic;


    public AStarPathFinder(TileBasedMap map, int maxSearchDistance, boolean allowDiagonalMovt){
        this(map, maxSearchDistance, allowDiagonalMovt, new ClosestHeuristic());
    }

    public AStarPathFinder(TileBasedMap map, int maxSearchDistance, boolean allowDiagonalMovt, AStarHeuristic heuristic){
        this.heuristic = heuristic;
        this.map = map;
        this.maxSearchDistance = maxSearchDistance;
        this.allowDiagonalMovt = allowDiagonalMovt;

        nodes = new Node[map.getTilesWidth()][map.getTilesHeight()];
        for (int x = 0; x < map.getTilesWidth(); x++){
            for (int y = 0; y < map.getTilesHeight(); y++){
                nodes[x][y] = new Node(x,y);
            }
        }
    }




}
