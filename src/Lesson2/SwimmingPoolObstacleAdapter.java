package Lesson2;

public class SwimmingPoolObstacleAdapter implements Obstacle{

    private final SwimmingPool swimmingPool;

    public SwimmingPoolObstacleAdapter(SwimmingPool swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Override
    public boolean overcome(Participant participant) {
        return swimmingPool.overcome(participant);
    }

    @Override
    public String type() {
        return "Бассейн";
    }
}
