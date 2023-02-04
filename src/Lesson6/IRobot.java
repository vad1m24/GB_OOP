package Lesson6;

public interface IRobot {

    void move() throws RobotMoveException;

    void move(int moveLength) throws RobotMoveException;

    void changeDirection(Direction direction);

    Long getId();

    DefaultRobotMap.MapPoint getPoint();

}
