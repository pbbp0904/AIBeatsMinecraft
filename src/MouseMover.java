import java.awt.*;

public class MouseMover {
    Robot robot = new Robot();

    public MouseMover() throws AWTException {
    }

    public void moveMouse(int[] coords) throws AWTException {
        robot.mouseMove(coords[0], coords[1]);
    }

    public void moveMouse(int x, int y) {
        robot.mouseMove(x, y);
    }
}
