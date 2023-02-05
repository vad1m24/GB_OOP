package Lesson7.HomeWork;

public class RoundRegHoleMachine {

    public IRoundHole create(IRoundPeg peg){
        return new DefaultRondHole(peg.radius());
    }

}
