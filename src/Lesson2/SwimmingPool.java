package Lesson2;

public class SwimmingPool  {

    private final int distance;

    public SwimmingPool(int distance) {
        this.distance = distance;
    }

    public boolean overcome(Swimmable swimmable) {
        int swimLimit = swimmable.getSwimLimit();
        return swimLimit >= distance;
    }

    public int getDistance() {
        return distance;
    }
}
