package Lesson6;

public interface CommandExecutor {
    String execute(String[] args) throws CommandExecutionException, RobotMoveException;
}
