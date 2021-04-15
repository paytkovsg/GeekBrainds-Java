package lesson5;

public class Cat extends Animals{
    Cat(String name, float maxRun, float maxJump, float maxSwim){
        super("Кот", name, maxRun, maxJump, maxSwim);
    }
    @Override //переопределяем метод, т.к. животное плавать не умеет
    protected int swim(float distance) {
        return Animals.swim_none;
    }
}
