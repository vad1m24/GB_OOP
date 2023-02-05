package Lesson7.HomeWork;

public class DefaultRoundPeg implements IRoundPeg {

    private final double radius;

    public DefaultRoundPeg(double radius) {
        this.radius = radius;
    }

    @Override
    public double radius() {
        return radius;
    }

}
