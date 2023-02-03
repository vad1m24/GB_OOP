package Lesson5;

public interface CommandExecutor {
    String execute(String[] args) throws CommandExecutionException, RobotMoveException;
}
