import java.awt.*;

public class MouseMover {
    public void moveMouse(int[] coords) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(coords[0], coords[1]);
    }
}
