public class Waiter {

    private static final int shortSleepTime;
    private static final int longSleepTime;
    private static final int stationaryWaitTime;


    static{
        shortSleepTime = 50;
        longSleepTime = 100;
        stationaryWaitTime = 1500;
    }



    // Getters
    public static int getShortSleepTime() throws InterruptedException {
        AIBM.checkInterrupted();
        return shortSleepTime;
    }

    public static int getLongSleepTime() throws InterruptedException {
        AIBM.checkInterrupted();
        return longSleepTime;
    }

    public static int getStationaryWaitTime() throws InterruptedException {
        AIBM.checkInterrupted();
        return stationaryWaitTime;
    }


    // Methods
    public static void wait(int time) throws InterruptedException {
        AIBM.checkInterrupted();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            AIBM.checkInterrupted();
        }
    }

    public static void waitShort() throws InterruptedException {
        AIBM.checkInterrupted();
        try {
            Thread.sleep(shortSleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            AIBM.checkInterrupted();
        }
    }

    public static void waitLong() throws InterruptedException {
        AIBM.checkInterrupted();
        try {
            Thread.sleep(longSleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            AIBM.checkInterrupted();
        }
    }
}
