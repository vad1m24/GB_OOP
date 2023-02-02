package Lesson5;

public class RobotMoveException extends Exception {

    private final RobotMap.Robot robot;

    public RobotMoveException(String message, RobotMap.Robot robot) {
        super(message);
        this.robot = robot;
    }

    public RobotMap.Robot getRobot() {
        return robot;
    }
}