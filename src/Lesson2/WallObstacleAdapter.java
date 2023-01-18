package Lesson2;

public class WallObstacleAdapter implements Obstacle {

    private final Wall wall;

    public WallObstacleAdapter(Wall wall) {
        this.wall = wall;
    }


    @Override
    public boolean overcome(Participant participant) {
        return wall.overcome(participant);
    }

    @Override
    public String type() {
        return "Стена";
    }
}
