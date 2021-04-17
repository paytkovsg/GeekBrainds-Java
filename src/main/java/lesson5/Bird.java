package lesson5;

public class Bird extends Animals {
    Bird(String name, float maxRun, float maxJump, float maxSwim) {
        super("Птица", name, maxRun, maxJump, maxSwim);
    }

    @Override //переопределяем метод, т.к. животное плавать не умеет
    protected int swim(float distance) {
        return Animals.swim_none;
    }
}
