package Lesson2;

public class RopeObstacleAdapter implements Obstacle {

    public final Rope rope;

    public RopeObstacleAdapter(Rope rope) {
        this.rope = rope;
    }

    @Override
    public boolean overcome(Participant participant){
        return rope.overcome(participant);
    }

    @Override
    public String type() {
        return "Канат";
    }

}
