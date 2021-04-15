package lesson4;
// Создаем поля класса
public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String phone;
    private float salary;
    boolean salaryChanged; // по умолчанию false
    private int age;
    private int uid;

    // определяем начальный id, должен быть static, т.к. к объекту не относится
    private static int id = 0;

    // Создаем конструктор
    public Employee(String surname, String name, String patronymic,
                    String position, String phone,
                    float salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.uid = ++id; // приращение id на 1 при создании

    }

    // Задание 3. Методы, возвращающие значение полей

    String getSurname() {
        return surname;
    }
    String getName() {
        return name;
    }
    String getPatronymic() {
        return patronymic;
    }
    String getPosition() {
        return position;
    }
    String getPhone() {
        return phone;
    }
    int getSalary() {
        return (int) salary;
    }
    //Приращение зп
    void setSalary(float difference) {
        this.salary = this.salary + difference;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getAge() {
        return age;
    }
    //метод, вывадящий в консоль полную инфу о сотруднике в одну строку
    String getFullInfo() {
        return this.uid + "." +
                "ФИО: " + this.surname + " " + this.name + " " + this.patronymic + ", " +
                "должность: " + this.position + ", " +
                "телефон: " + this.phone + ", " +
                "Оклад: " +  this.salary + ", " +
                "возраст: " +  this.age;
    };


}
