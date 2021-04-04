package homework;

public class homework1 {
    public static void main(String[] args) {
        System.out.println("Задание 1: " + computation (3, 4, 15, 4));
        System.out.println("Задание 2: " + within10and20 (10, 8));
        if (numberСheck (5)) {
            System.out.println("Задание 3: Положительное" );
        } else {
            System.out.println("Задание 3: Отрицательное");
        }

        printName("junior java development");
        System.out.println("Задание 5: Год високосный? " + leapYear (2021));
    }
    // 1 метод вычисляющий выражение a * (b + (c / d))
    public static float computation (int a, int b, int c, float d) {
        return a * (b + ((float) c / d ));
    }
    // Задание 2 Метод, проверяющий что сумма лежит в пределах от 10 до 20(включительно)

    public static boolean within10and20 (int a, int b) {
        return (a + b >= 10) && (a + b <= 20);
    }

    // Задание 3 Метод, проверяющий положительное или отрицательное число передали
    public static boolean numberСheck (int a) {
        return a >= 0;
    }
    // Задание 4 метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вернуть приветственное сообщение «Привет, переданное_имя!»
    public static String printName(String name) {
        String printName = "Привет, " + name + "!";
        System.out.println("Задание 4: Привет, " + name + "!");
        return printName;
    }
    public static boolean leapYear (int year) {
        return (year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0);
    }


}
