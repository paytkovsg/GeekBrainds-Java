package lesson4;

public class homework4 {

    public static void main (String[] args){

        // Задание 1. Создаем объект класса "Сотрудник". В аргументах указываем значение полей
        Employee employee1 = new Employee ("Иванов", "Иван", "Иванович",
                "менеджер", "+7 495 3332222", 45000, 35);

        // Задание 4. Вывести из п. 3 ФИО, должность
  //      System.out.println(employee1.getSurname() + "," + employee1.getName() + "," + employee1.getPatronymic() + "," +
  //            employee1.getPosition());
        System.out.println(employee1.getFullInfo());

        // Задание 5. Создать массив из 5 сотрудников. Вывести информацию о тех, кому больше 40 лет
        // Создаем массив, в качестве параметров передаем данные полей
        Employee[] employees = {
                employee1,
                new Employee("Петров", "Иван", "Алексеевич", "Разработчик",
                        "+7 495 3332222", 100000, 43),
                new Employee("Сидорова", "Ольга", "Николаевна", "Офис-менеджер",
                        "+7 495 3332222", 30000, 25),
                new Employee("Тестовый", "Тестер", "Тестерович", "Тестировщик",
                        "+7 495 3332222", 80000, 37),
                new Employee("Сотрудников", "Сотрудник", "Сотрудникович",
                        "директор", "+7 495 3332222", 150000, 48)
        };
        // вывод сотрудников, кому бальше 40 лет
        for (int i = 0; i < employees.length; i++)
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getFullInfo());
            }
        System.out.println();

        //условие повышения зп
        increaseSalary(employees, 35, 10000);
       // если сотруднику повысили зп, вывод в консоль этого сотрудника
        for (int i = 0; i < employees.length; i ++)
            if (employees[i].salaryChanged)
                System.out.println(employees[i].getFullInfo());


    }

// Метод определяет кому повышать зп. Проходит по циклу, если возраст больше, чем заданный, обращается к методу
    // setSalary и производит приращение зп на инкремент
    private static void increaseSalary(Employee[] emp, int age, float increment) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                emp[i].setSalary(increment);
                emp[i].salaryChanged = true;
            }
        }
    }


}
