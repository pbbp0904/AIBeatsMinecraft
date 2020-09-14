import java.io.IOException;

public class ThreadHandler implements Runnable {

    Thread t;

    ThreadHandler()
    {
        t = new Thread(this);
        System.out.println("New thread: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            AIBM.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
