package Lesson6;

public class RobotMapFactory {
    public IRobotMap create(int n, int m) throws RobotCreationException {
        return new DefaultRobotMap(n, m);
    }
}
