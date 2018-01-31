package pathFinding;
import java.util.ArrayList;

public class Path {

    private ArrayList steps = new ArrayList();

    public Path(){
        // an empty path
    }

    public int getLength(){
        return steps.size();
        // returns length of path taken
    }

    public Step getStep(int index){
        return (Step) steps.get(index);
        // gets step at a given index
        // @param index is the index of the step to retrieve where index >= 0 && index < getLength()

    }

    public int getX(int index){
        return getStep(index).x;
        // returns x coordinate of the index of a given step

    }

    public int getY(int index){
        return getStep(index).y;
        // returns x coordinate of the index of a given step
    }

    public void appendStep(int x, int y){
        steps.add(new Step(x,y));
        // appends step to a path
    }

    public void prependStep(int x, int y){
        steps.add(0, new Step(x,y));
        // prepends step to a path
    }

    public boolean contains(int x, int y){
        return steps.contains(new Step(x,y));
        // checks if path already contains given step
    }

    public class Step{
        // A single step in the path

        private int x;      // x coordinate
        private int y;      // y coordinate

        public Step(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public int hashCode(){
            return x*y;
        }

        public boolean equals(Object other){
            if (other instanceof Step){
                Step o = (Step) other;
                return (o.x == x) && (o.y == y);
            }

            return false;
        }
    }
}
