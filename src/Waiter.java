public class Waiter {

    private static final int shortSleepTime;
    private static final int longSleepTime;
    private static final int stationaryWaitTime;


    static{
        shortSleepTime = 40;
        longSleepTime = 120;
        stationaryWaitTime = 1500;
    }



    // Getters
    public static int getShortSleepTime() throws InterruptedException {
        checkInterrupted();
        return shortSleepTime;
    }

    public static int getLongSleepTime() throws InterruptedException {
        checkInterrupted();
        return longSleepTime;
    }

    public static int getStationaryWaitTime() throws InterruptedException {
        checkInterrupted();
        return stationaryWaitTime;
    }


    // Methods
    public static void wait(int time) throws InterruptedException {
            Thread.sleep(time);
    }

    public static void waitShort() throws InterruptedException {
            Thread.sleep(shortSleepTime);
    }

    public static void waitLong() throws InterruptedException {
            Thread.sleep(longSleepTime);
    }

    public static void waitStationary() throws InterruptedException {
            Thread.sleep(stationaryWaitTime);
    }

    private static void checkInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
    }

}
