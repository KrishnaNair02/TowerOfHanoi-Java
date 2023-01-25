/**
 * 
 */
package towerofhanoi;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * Class that creates the towers
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;
    
    /**
     * new Tower object
     * @param position
     *          the location this tower correlates to
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
    
    /**
     * returns the position of this tower
     * @return the position of this tower
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * Checks to see if adding a disk to a tower is allowed
     * @param disk
     *          disk that is being pushed onto this tower
     * @Override
     */
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().compareTo(disk) == 1)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
}
