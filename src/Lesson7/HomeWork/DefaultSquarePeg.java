package Lesson7.HomeWork;

public class DefaultSquarePeg implements ISquarePeg {

    private final double side;

    public DefaultSquarePeg(double side) {
        this.side = side;
    }

    @Override
    public double side() {
        return side;
    }

}
