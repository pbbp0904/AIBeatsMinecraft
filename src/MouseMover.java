import java.awt.*;

public class MouseMover {

    private static Robot robot;
    private static final int shortSleep;
    

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        shortSleep = 100;
    }

    public static void moveMouse(int[] coords) throws InterruptedException {
        checkInterrupted();
        robot.mouseMove(coords[0], coords[1]);
        Waiter.wait(shortSleep);
    }

    public static void moveMouse(int[] coords, int sleepTime) throws InterruptedException {
        checkInterrupted();
        robot.mouseMove(coords[0], coords[1]);
        Waiter.wait(sleepTime);
    }

    public static void moveMouse(int x, int y) throws InterruptedException {
        checkInterrupted();
        robot.mouseMove(x, y);
        Waiter.wait(shortSleep);
    }

    public static void moveMouse(int x, int y, int sleepTime) throws InterruptedException {
        checkInterrupted();
        robot.mouseMove(x, y);
        Waiter.wait(sleepTime);
    }

    public static void moveMouseAway() throws InterruptedException {
        checkInterrupted();
        robot.mouseMove(Looker.getTableCraftSlotRes()[0], Looker.getTableCraftSlotRes()[1]);
        Waiter.wait(shortSleep);
    }

    private static void checkInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            Typer.releaseAllKeys();
            throw new InterruptedException();
        }
    }
}
