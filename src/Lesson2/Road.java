package Lesson2;

public class Road {

    private final int distance;

    public Road(int distance) {
        this.distance = distance;
    }

    public boolean overcome(Runnable runnable) {
        int distanceLimit = runnable.getDistanceLimit();
        return distanceLimit >= distance;
    }

    public int getDistance() {
        return distance;
    }
}
