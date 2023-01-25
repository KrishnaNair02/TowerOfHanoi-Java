/**
 * 
 */
package towerofhanoi;

/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 */
public class ProjectRunner 
{
    
    /**
     * Runs the project
     */
    public ProjectRunner()
    {
        
    }
    
    /**
     * Sets up the environment of the program
     * allowing it to be interacted with
     * @param args
     *          arguments to set up specific instance
     */
    public static void main(String[] args)
    {
        int disks = 6;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hs1 = new HanoiSolver(disks);
        PuzzleWindow pw1 = new PuzzleWindow(hs1);
    }
}
