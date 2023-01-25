/**
 * 
 */
package towerofhanoi;
import java.util.Observable;
import java.util.Observer;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.*;
import cs2.Shape;
import cs2.CircleShape;
import cs2.SquareShape;
import cs2.TextShape;
/**
 * @author Krishna Nair (krishnanair)
 * @version 2021.10.17
 * Creates the GUI for the puzzle
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int WIDTH_FACTOR = 30;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 8;
    
    /**
     * adds a pause between the moving of disks
     */
    private void sleep() 
    {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

    /**
     * allows the solve button to function
     * @param button
     *          the button that will be made the
     *          solve button
     */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * moves the disk to the correct spot on the screen
     * @param position
     *          where the disk will be moved to
     */
    private void moveDisk(Position position)
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = left;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        if (position == Position.MIDDLE)
        {
            currentPole = middle;
        }
        if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        int x = currentPole.getX() + currentPole.getWidth() / 2 - currentDisk.getWidth() / 2;
        int y = currentPole.getY() + currentPole.getHeight() - 
            game.getTower(position).size() * (DISK_HEIGHT);
        currentDisk.moveTo(x,  y);
    }
    
    /**
     * New PuzzleWindow object
     * @param game
     *          the puzzle that will be solved
     */
    public PuzzleWindow(HanoiSolver game)
    {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        int x = window.getGraphPanelWidth();
        int y = window.getGraphPanelHeight() / 2;
        left = new Shape(x / 6, y, 3, 120, Color.BLACK);
        middle = new Shape(x / 2, y, 3, 120, Color.BLACK);
        right = new Shape(5 * x / 6 , y, 3, 120, Color.BLACK);
        for (int i = game.disks(); i >= 1; i--)
        {
            Disk newDisk = new Disk(15 * i);
            window.addShape(newDisk);
            game.getTower(Position.LEFT).push(newDisk);
            moveDisk(Position.LEFT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }

    /**
     * calls the notifyObservers() method
     * @param arg
     *          the argument
     */
    @Override
    public void update(Observable o, Object arg) 
    {
        if (arg.getClass().equals(Position.class))
        {
            Position theArg = (Position) arg;
            moveDisk(theArg);
            sleep();
        }
    }
}

