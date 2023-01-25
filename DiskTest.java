/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 *
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * New test class for Disk
 */
public class DiskTest extends TestCase {

    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;
    private Disk diskNull;
    private Disk diskSame;
    private Object obj;
    
    /**
     * Sets up test cases
     */
    public void setUp()
    {
        disk1 = new Disk(10);
        disk2 = new Disk(10);
        disk3 = new Disk(12);
        disk4 = new Disk(8);
        diskNull = null;
        diskSame = disk1;
        obj = new Object();
    }
    
    /**
     * tests the compareTo() method
     */
    public void testCompareTo()
    {
        Exception thrown = null;
        try 
        {
            disk1.compareTo(diskNull);
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals(disk1.compareTo(disk2), 0);
        assertEquals(disk1.compareTo(disk3), -1);
        assertEquals(disk1.compareTo(disk4), 1);
    }
    
    /**
     * tests the toString() method
     */
    public void testToString()
    {
        assertTrue(disk1.toString().equals("10"));
    }
    
    /**
     * tests the equals() method
     */
    public void testEquals()
    {
        assertTrue(disk1.equals(diskSame));
        assertFalse(disk1.equals(obj));
        assertFalse(disk1.equals(diskNull));
        assertTrue(disk1.equals(disk2));
        assertFalse(disk1.equals(disk3));
    }
}
