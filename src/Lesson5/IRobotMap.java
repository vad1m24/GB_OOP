package Lesson5;

public interface IRobotMap {

    RobotMap.Robot getRobobtByID(Long id);
    RobotMap.Robot createRobot(Point point) throws RobotCreationException;

}
