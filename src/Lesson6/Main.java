package Lesson6;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");
        System.out.println("...описание...");

        RobotMapFactory robotMapFactory = new RobotMapFactory();
        IRobotMap map;
        while (true) {
            System.out.println("Для создания карты введите 2 положительных числа через пробел");
            try {
                int n = userInput.nextInt();
                int m = userInput.nextInt();
                userInput.nextLine();

                map = robotMapFactory.create(n, m);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Возникла ошибка при создании карты: " + e.getMessage());
                userInput.nextLine();
            } catch (Throwable e) {
                System.err.println("Возникла ошибка на стороне сервера: " + e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Карта успешно создана!");

        CommandManager commandManager = new CommandManager(map);

        System.out.println("Для просмотра списка допустимых команд введите h");

        while (true) {
            System.out.println("Введите команду");
            String command = userInput.nextLine();
            try {
                String commandExecutionResult = commandManager.handleCommand(command);
                if (Objects.nonNull(commandExecutionResult) && !commandExecutionResult.isBlank()) {
                    System.out.println(commandExecutionResult);
                }
            } catch (CommandNotFoundException e) {
                System.err.println("Команда [" + e.getMessage() + "] не найдена");
            } catch (CommandExecutionException | RobotMoveException e) {
                System.err.println("Во время исполнения команды произошла ошибка: " + e.getMessage());
            }
        }
    }

    private static class CommandManager {

        private final IRobotMap map;
        private final Map<String, CommandExecutor> commands;

        public CommandManager(IRobotMap map) {
            this.map = map;

            commands = new HashMap<>();
            commands.put("h", this::printHelp);
            commands.put("q", this::quit);
            commands.put("a", this::addRobot);
            commands.put("l", this::listRobots);
            commands.put("m", this::moveRobots);
            commands.put("cd", this::changeDirectionRobots);
        }

        public String handleCommand(String command) throws CommandNotFoundException, CommandExecutionException, RobotMoveException {
            String[] split = command.split(" ");
            String commandCode = split[0];

            CommandExecutor executor = commands.get(commandCode);
            if (executor == null) {
                throw new CommandNotFoundException(command);
            }

            String[] args = Arrays.copyOfRange(split, 1, split.length);
            return executor.execute(args);
        }

        private String addRobot(String[] args) throws CommandExecutionException {
            if (args.length < 2) {
                throw new CommandExecutionException("Недостаточно аргументов");
            }

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            try {
                map.createRobot(new Point(x, y));
            } catch (RobotCreationException e) {
                throw new CommandExecutionException(e.getMessage());
            }

            return null;
        }


        private String listRobots(String[] args) {
            return String.valueOf(map.getRobots());
        }

        private String moveRobots(String[] id) throws RobotMoveException {
            long l = Long.parseLong(id[0]);
            IRobot robot = map.getRobotByID(l);
            robot.move();
            return null;
        }

        private String changeDirectionRobots(String[] args) {
            long l = Long.parseLong(args[0]);
            IRobot robot = map.getRobotByID(l);
            switch (args[1]) {
                case "t" -> robot.changeDirection(Direction.TOP);
                case "r" -> robot.changeDirection(Direction.RIGHT);
                case "b" -> robot.changeDirection(Direction.BOTTOM);
                case "l" -> robot.changeDirection(Direction.LEFT);
            }
            return null;
        }

            private String printHelp (String[]args){
                return """
                        h                  -> распечатать список допустимых команд (help)
                        a 1 2              -> создать робота на позиции (1, 2) (add)
                        l                  -> распечатать всех роботов (list)
                        m id [5]           -> перемещаем робота на 1 единицу вперед (move)
                        cd id [t, r, b, l] -> изменить направление робота (change direction)
                        q                  -> завершить программу (quit)
                        """;
            }

            private String quit (String[]args){
                System.exit(0);
                return null;
            }
        }
    }