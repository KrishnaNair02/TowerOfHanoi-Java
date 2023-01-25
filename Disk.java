/**
 * 
 */
package towerofhanoi;
import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * New Disk object
     * @param width
     *          the width of the new disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        int color1 = randomGenerator.nextInt(255);
        int color2 = randomGenerator.nextInt(255);
        int color3 = randomGenerator.nextInt(255);
        this.setBackgroundColor(new Color(color1, color2, color3));
    }
    
    /**
     * compares one disk's width to another
     * @param otherDisk
     *          what this disk is being compared to
     * @return 1 if this disk is wider, -1 if otherDisk is wider,
     * or 0 if they are the same size
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        else if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        else if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * returns this disk's width as a string
     * @return this disk's width as a string
     */
    public String toString()
    {
        String returned = String.valueOf(getWidth());
        return returned;
    }
    
    /**
     * Checks to see if the disk is equal to the 
     * input object
     * @param obj 
     *          the object this disk is being
     *          compared to
     * @return true or false if the objects are equal or not
     * respectively
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass().equals(obj.getClass()))
        {
            Disk otherDisk = (Disk) obj;
            if (this.getWidth() == otherDisk.getWidth())
            {
                return true;
            }
        }
        return false;
    }
}
