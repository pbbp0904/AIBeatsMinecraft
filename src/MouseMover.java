import java.awt.*;

public class MouseMover {

    int[] moveAwayCoords = new int[]{200, 200};

    Robot robot;
    Waiter waiter;

    public MouseMover() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        waiter = new Waiter();
    }

    public void moveMouse(int[] coords){
        robot.mouseMove(coords[0], coords[1]);
        try {
            Thread.sleep(waiter.getShortSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveMouse(int[] coords, int sleepTime){
        robot.mouseMove(coords[0], coords[1]);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveMouse(int x, int y)  {
        robot.mouseMove(x, y);
        try {
            Thread.sleep(waiter.getShortSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveMouse(int x, int y, int sleepTime)  {
        robot.mouseMove(x, y);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveMouseAway(){
        robot.mouseMove(moveAwayCoords[0], moveAwayCoords[1]);
        try {
            Thread.sleep(waiter.getShortSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
