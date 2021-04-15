package lesson5;

public class Homework5 {
    public static void main(String[] args) {
        //объявляем временные переменные сделано/не сделано, наименование события, результат
        String tempDone = " получилось;";
        String tempNotDon = " не получилось";
        String eventName;
        String eventResult;

        //Создаем животных, задаем максимальные параметры
        Dog dog1 = new Dog("Шарик", 500, 0.5f, 10);
        Horse horse1 = new Horse("Лошадь", 1500, 3, 100);
        Bird bird1 = new Bird("Кеша", 5, 10, 2);
        Cat cat1 = new Cat("Васька", 200, 0.2f, 1);

        //Создаем массив животных
        Animals[] arr = {dog1, horse1, bird1, cat1};

        // Определяем события
        float maxRunLength = 300;
        float maxJumpLength = 1.5f;
        float maxSwimLength = 6;

        for (int i = 0; i < arr.length; i++){
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может";

            eventName = "прыгнуть на " + arr[i].getMaxJump() + " м." + " Пытается прыгнуть на ";
            eventResult = (arr[i].jump(maxJumpLength)) ? tempDone : tempNotDon;
            result(nameString, eventName, maxJumpLength, eventResult);

            eventName = "пробежать на " + arr[i].getMaxRun() + " м." + " Пытается пробежать на ";
            eventResult = (arr[i].run(maxRunLength)) ? tempDone : tempNotDon;
            result(nameString, eventName, maxRunLength, eventResult);

            int swimResult = arr[i].swim(maxSwimLength);
            eventName = "проплыть на " + arr[i].getMaxSwim() + " м." + " Пытается проплыть на ";
            eventResult = (swimResult == Animals.swim_ok) ? tempDone : tempNotDon;

            if (swimResult == Animals.swim_none)
                eventResult = " не получилось, плавать не умеет";
            result(nameString, eventName, maxSwimLength, eventResult);


        }


    }
    private static void result(String nameAnimals, String eventName, float eventLength, String eventResult) {
        System.out.println(nameAnimals + " " + eventName + eventLength + " м " + eventResult);
    }




}
