/**
 * 
 */
package towerofhanoi;
import student.TestCase;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * test class for Tower
 */
public class TowerTest extends TestCase {

    private Tower t1;
    private Disk bigDisk;
    private Disk smallDisk;
    private Disk nullDisk;
    
    /**
     * sets up the test cases
     */
    public void setUp()
    {
        t1 = new Tower(Position.LEFT);
        bigDisk = new Disk(10);
        smallDisk = new Disk(8);
        nullDisk = null;
    }
    
    /**
     * tests the position() method
     */
    public void testPosition()
    {
        assertTrue(t1.position().equals(Position.LEFT));
    }
    
    /**
     * tests the push() method
     */
    public void testPush()
    {
        Exception exception = null;
        try
        {
            t1.push(nullDisk);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception instanceof IllegalArgumentException);
        t1.push(smallDisk);
        assertEquals(t1.peek(), smallDisk);
        Exception exception1 = null;
        try
        {
            t1.push(bigDisk);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception1 = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
                   exception1 instanceof IllegalStateException);
    }
}
