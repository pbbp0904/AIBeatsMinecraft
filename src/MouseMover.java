import java.awt.*;

public class MouseMover {
    Robot robot = new Robot();

    public MouseMover() throws AWTException {
    }

    public void moveMouse(int[] coords, int sleepTime) throws AWTException, InterruptedException {
        robot.mouseMove(coords[0], coords[1]);
        Thread.sleep(sleepTime);
    }

    public void moveMouse(int x, int y, int sleepTime) throws InterruptedException {
        robot.mouseMove(x, y);
        Thread.sleep(sleepTime);
    }
}
