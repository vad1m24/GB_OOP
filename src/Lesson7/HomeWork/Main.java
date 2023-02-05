package Lesson7.HomeWork;

public class Main {
    public static void main(String[] args) {

        /**
         // Есть машина, которая умеет делать круглые отверстия для круглых колышков (RoundPeg).
         // Также у нас есть квадратные колышки (SquareSide).
         // Задача: научить машину делать отверстия для квадратных колышков (реализовать паттерн адаптер).
         // Нужно "адаптировать" интерфейс SquarePeg под интерфейс RoundPeg
         */

        RoundRegHoleMachine machine = new RoundRegHoleMachine();
        IRoundPeg peg = new DefaultRoundPeg(2.0);
        IRoundHole hole = machine.create(peg);
        System.out.println(hole.radius());

        ISquarePeg squarePeg = new DefaultSquarePeg(5.0);
        IRoundHole hole2 = machine.create(new Adapter(squarePeg));
        System.out.println(hole2.radius());
    }
}
