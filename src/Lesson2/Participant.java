package Lesson2;

public abstract class Participant implements Runnable, Jumpable, Swimmable, Climbable {

    private final String name;
    private final int distanceLimit;
    private final int swimLimit;
    private final int jumpLimit;
    private final int climbLimit;

    public Participant(String name, int distanceLimit, int swimLimit, int jumpLimit, int climbLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
        this.climbLimit = climbLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDistanceLimit() {
        return distanceLimit;
    }

    @Override
    public int getSwimLimit() {
        return swimLimit;
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public int getClimbLimit() {
        return climbLimit;
    }
}
