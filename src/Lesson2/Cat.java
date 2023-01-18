package Lesson2;

public class Cat extends Participant {

    public Cat(String name, int distanceLimit, int jumpLimit, int climbLimit) {
        super(name, distanceLimit, -1, jumpLimit, climbLimit);
    }

}