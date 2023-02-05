package Lesson7.HomeWork;

public class DefaultRondHole implements IRoundHole{

    private final double radius;

    public DefaultRondHole(double radius) {
        this.radius = radius;
    }

    @Override
    public double radius() {
        return radius;
    }

}
