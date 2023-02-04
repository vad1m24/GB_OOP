package Lesson6;

import java.util.List;

public interface IRobotMap {

    IRobot getRobotByID(Long id);
    void createRobot(Point point) throws RobotCreationException;
    List<DefaultRobotMap.Robot> getRobots();

}
