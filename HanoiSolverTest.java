/**
 * 
 */
package towerofhanoi;
import student.TestCase;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * Test class for HanoiSolver
 */
public class HanoiSolverTest extends TestCase 
{
    private HanoiSolver hs1;
    private Disk d1;
    private Disk d2;
    private Disk d3;
    
    /**
     * sets up the test cases
     */
    public void setUp()
    {
        hs1 = new HanoiSolver(3);
        d1 = new Disk(4);
        d2 = new Disk(5);
        d3 = new Disk(6);
    }
    
    /**
     * tests the disks() method
     */
    public void testDisks()
    {
        assertEquals(hs1.disks(), 3);
    }
    
    /**
     * tests the getTower() method
     */
    public void testGetTower()
    {
        assertEquals(hs1.getTower(Position.LEFT).position(), Position.LEFT);
        assertEquals(hs1.getTower(Position.MIDDLE).position(), Position.MIDDLE);
        assertEquals(hs1.getTower(Position.RIGHT).position(), Position.RIGHT);
        assertEquals(hs1.getTower(Position.DEFAULT).position(),
            Position.MIDDLE);
    }
    
    /**
     * tests the solve() method, which tests the move() and 
     * solveTowers() methods as well
     */
    public void testSolve()
    {
        hs1.getTower(Position.LEFT).push(d3);
        hs1.getTower(Position.LEFT).push(d2);
        hs1.getTower(Position.LEFT).push(d1);
        hs1.solve();
        assertEquals(hs1.getTower(Position.RIGHT).size(), 3);
    }
    
    /**
     * tests the toString() method
     */
    public void testToString()
    {
        hs1.getTower(Position.LEFT).push(d3);
        hs1.getTower(Position.MIDDLE).push(d2);
        hs1.getTower(Position.RIGHT).push(d1);
        assertTrue(hs1.toString().equals("[6][5][4]"));
    }
}
