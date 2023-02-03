package Lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RobotMap implements IRobotMap {

    private final int n;

    private final int m;

    private static List<Robot> robots;

    private final int maxRobotCount = 10;
    public RobotMap(int n, int m) throws RobotCreationException {
        checkMapSize(n, m);

        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();

    }

    public Robot getRobobtByID(Long id) {
        Optional<Robot> any = robots.stream().filter(robot -> robot.getId().equals(id)).findAny();
        if (any.isPresent()) {
            return any.get();
        } else {
            throw new RuntimeException("Робот не найден");
        }
    }

    public static List<Robot> getRobots() {
        return robots;
    }

    private void checkMapSize(int n, int m) throws RobotCreationException {
        if (n < 1 || m < 1) {
            throw new RobotCreationException("Заданные параметры карты ошибочны");
        }
    }

    public Robot createRobot(Point point) throws RobotCreationException {
        final MapPoint robotPosition;
        try {
            checkRobotsCount();
            validatePoint(point);
            robotPosition = new MapPoint(point.getX(), point.getY());
        } catch (PointValidationException e) {
            throw new RobotCreationException(e.getMessage());
        }

        Robot robot = new Robot(robotPosition);
        robots.add(robot);
        return robot;
    }

    private void checkRobotsCount() {
        if (robots.size() >= maxRobotCount) {
            throw new IllegalArgumentException("Превышено максимальное количество ботов");
        }
    }

    private void validatePoint(Point point) throws PointValidationException {
        validatePointIsFree(point);
    }

    private void validatePointIsFree(Point point) throws PointValidationException {
        for (Robot robot : robots) {
            if (point.equals(robot.getPoint())) {
                throw new PointValidationException("Позиция " + point + " занята другим роботом: " + robot);
            }
        }
    }


    public class Robot {


        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private static Long idSequence = 1L;

        private final Long id;
        private MapPoint point;
        private Direction direction;
        private int moveLength;

        public Robot(MapPoint point) {
            this.id = idSequence++;
            this.point = point;
            this.direction = DEFAULT_DIRECTION;
        }

        public void move() throws RobotMoveException {
            final MapPoint newPoint;
            try {
                newPoint = switch (direction) {
                    case TOP -> new MapPoint(point.getX() - 1, point.getY());
                    case RIGHT -> new MapPoint(point.getX(), point.getY() + 1);
                    case BOTTOM -> new MapPoint(point.getX() + 1, point.getY());
                    case LEFT -> new MapPoint(point.getX(), point.getY() - 1);
                };

                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }

            this.point = newPoint;
        }

        public void move(int moveLength) throws RobotMoveException {
            final MapPoint newPoint;
            try {
                newPoint = switch (direction) {
                    case TOP -> new MapPoint(point.getX() - moveLength, point.getY());
                    case RIGHT -> new MapPoint(point.getX(), point.getY() + moveLength);
                    case BOTTOM -> new MapPoint(point.getX() + moveLength, point.getY());
                    case LEFT -> new MapPoint(point.getX(), point.getY() - moveLength);
                };
                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }
            this.moveLength = moveLength;
            this.point = newPoint;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public Robot getRobot(Long n) throws PointValidationException {
            Robot chosenRobot = null;
            for (Robot robot : robots) {
                if (n.equals(robot.getId())) {
                    chosenRobot = robot;
                }
            }
            return chosenRobot;
        }

        public Long getId() {
            return id;
        }

        public MapPoint getPoint() {
            return point;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Robot)) return false;
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "Robot-" + id + point;
        }
    }

    public class MapPoint extends Point {

        public MapPoint(int x, int y) throws PointValidationException {
            super(x, y);

            if (x < 0 || x > n || y < 0 || y > m) {
                throw new PointValidationException("Недопустимое значение Point: " + this);
            }
        }
    }
}
