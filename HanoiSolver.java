/**
 * 
 */
package towerofhanoi;
import java.util.Observable;

/**
 * Solves the tower of hanoi puzzle
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * new HanoiSolver object
     * @param numDisks
     *          number of disks that need to be solved
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * returns how many disks are in the puzzle
     * @return the number of disks
     */
    public int disks()
    {
        return numDisks;
    }
    
    /**
     * returns the correct tower based on the input position
     * @param pos 
     *          the position of the tower 
     * @return the corresponding tower
     */
    public Tower getTower(Position pos)
    {
        if (pos == Position.LEFT)
        {
            return left;
        }
        else if (pos == Position.RIGHT)
        {
            return right;
        }
        else
        {
            return middle;
        }
    }
    
    /**
     * moves the disk to the set destination
     * @param source
     *          tower that the disk is being moved from
     * @param destination
     *          tower that the disk is being moved to
     */
    private void move(Tower source, Tower destination)
    {
        Disk popped = source.pop();
        destination.push(popped);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * recursive function that will move all of the disks from 1 pole
     * to another while abiding the rules laid out
     * @param currentDisks
     *          number of disks being moved around
     * @param startPole
     *          the pole from which the disk will be moved
     * @param tempPole
     *          the pole that will not be interacted with
     * @param endPole
     *          the pole to which the disk will be moved
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * initial call to solveTowers()
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
    
    /**
     * returns the state of the towers as a string
     * @return the state of the towers as a string
     */
    public String toString()
    {
        String theString = left.toString() + 
            middle.toString()+ right.toString();
        return theString;
    }
}
