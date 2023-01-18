package Lesson2;

public class Rope {

    private final int height;

    public Rope(int distance) {
        this.height = distance;
    }

    public boolean overcome(Climbable climbable){
        int climbLimit = climbable.getClimbLimit();
        return climbLimit >= height;
    }

    public int getHeight() {
        return height;
    }
}
