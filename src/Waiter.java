public class Waiter {

    private int shortSleepTime;
    private int longSleepTime;
    private int stationaryWaitTime;

    public Waiter(){
        shortSleepTime = 100;
        longSleepTime = 100;
        stationaryWaitTime = 1500;
    }

    public Waiter(int shortSleepTimeInput, int longSleepTimeInput, int stationaryWaitTimeInput){
        shortSleepTime = shortSleepTimeInput;
        longSleepTime = longSleepTimeInput;
        stationaryWaitTime = stationaryWaitTimeInput;
    }


    // Getters
    public int getShortSleepTime() {
        return shortSleepTime;
    }

    public int getLongSleepTime() {
        return longSleepTime;
    }

    public int getStationaryWaitTime() {
        return stationaryWaitTime;
    }

    // Setters
    public void setShortSleepTime(int shortSleepTime) {
        this.shortSleepTime = shortSleepTime;
    }

    public void setLongSleepTime(int longSleepTime) {
        this.longSleepTime = longSleepTime;
    }

    public void setStationaryWaitTime(int stationaryWaitTime) {
        this.stationaryWaitTime = stationaryWaitTime;
    }

    // Methods
    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
