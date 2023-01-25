/**
 * 
 */
package towerofhanoi;
import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * Test class from LinkedStack
 */
public class LinkedStackTest extends TestCase {

    private LinkedStack<Integer> stack1;
    /**
     * sets up the test cases
     */
    public void setUp()
    {
        stack1 = new LinkedStack<Integer>();
    }
    
    /**
     * tests the push() method
     */
    public void testPush()
    {
        stack1.push(12);
        assertEquals((int)stack1.peek(), 12);
        stack1.push(23);
        assertEquals((int)stack1.peek(), 23);
    }
    
    /**
     * tests the clear() method
     */
    public void testClear()
    {
        stack1.push(12);
        stack1.push(13);
        stack1.push(14);
        assertEquals(stack1.size(), 3);
        stack1.clear();
        assertEquals(stack1.size(), 0);
    }
    
    /**
     * tests the isEmpty() method
     */
    public void testIsEmpty()
    {
        assertTrue(stack1.isEmpty());
        stack1.push(12);
        assertFalse(stack1.isEmpty());
    }
    
    /**
     * tests the pop() method
     */
    public void testPop()
    {
        Exception thrown = null;
        try
        {
            stack1.pop();
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException); 
        stack1.push(12);
        stack1.push(24);
        assertEquals((int) stack1.pop(), 24);
        assertEquals((int) stack1.peek(), 12);
    }
    
    /**
     * tests the toString() method
     */
    public void testToString()
    {
        stack1.push(12);
        stack1.push(24);
        stack1.push(36);
        stack1.push(48);
        assertTrue(stack1.toString().equals("[48, 36, 24, 12]"));
    }
    
    /**
     * tests the peek() method
     */
    public void testPeek()
    {
        Exception thrown = null;
        try
        {
            stack1.pop();
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);       
    }
    
}
