public class Waiter {

    private static final int shortSleepTime;
    private static final int longSleepTime;
    private static final int stationaryWaitTime;


    static{
        checkInterrupted();
        shortSleepTime = 40;
        longSleepTime = 120;
        stationaryWaitTime = 1500;
    }



    // Getters
    public static int getShortSleepTime() {
        return shortSleepTime;
    }

    public static int getLongSleepTime() {
        return longSleepTime;
    }

    public static int getStationaryWaitTime() {
        return stationaryWaitTime;
    }


    // Methods
    public static void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitShort(){
        try {
            Thread.sleep(shortSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitLong(){
        try {
            Thread.sleep(longSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitStationary(){
        try {
            Thread.sleep(stationaryWaitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void checkInterrupted() {
        while (Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
