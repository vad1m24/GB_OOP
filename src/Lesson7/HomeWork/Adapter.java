package Lesson7.HomeWork;

public class Adapter implements IRoundPeg, ISquarePeg {

    private double radius;
    private final double side;

    public Adapter(ISquarePeg squarePeg) {
        double side = squarePeg.side();
        this.radius = Math.sqrt((Math.pow(side, 2) + Math.pow(side, 2)))/2;
        this.side = side;
    }

    @Override
    public double radius() {
        return radius;
    }

    @Override
    public double side() {
        return side;
    }
}
