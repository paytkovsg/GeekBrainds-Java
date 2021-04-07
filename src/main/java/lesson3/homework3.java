package lesson3;

import java.util.Random;
import java.util.Scanner;

public class homework3 {
    //объявляем поле
    public static char[][] gameField; //char, т.к. поле должно принимать символы

    // объявляем размеры поля
    public static int fieldSize = 4;

    // объявляем количество совпадений для победы
    public static int dotWin = 4;


    //объявляем значение для игрока, компьютера и пустой клетки

    public static char gamer = 'X'; // игрок
    public static char ai = '0'; //компьютер
    public static char empt = '*'; //пустое поле

    // объявляем сканер для ввода в консоль. Принимает строковое значение
    public static Scanner scanner = new Scanner(System.in);
    // объявляем рандом. Принимает значение float [0;1)
    public static Random random = new Random();


    // инициализируем игровое поле. Вложенный цикл заполняет двумерный массив значениями пустых полей
    public static void initGameField() {
        gameField = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField [i][j] = empt;
            }
        }
    }

    // вывод игрового поля в консоль
    public static void printGameField () {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(gameField[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    // ход игрока
    public static void gamerTurn() {
        int cellX, cellY;
        do {
            System.out.println("Введите координаты клетки");
            cellX = scanner.nextInt() - 1; // -1 это для удобства ввода (1-3), т.к. в массиве 0-2
            cellY = scanner.nextInt() - 1;

        } while (!cellValid(cellY, cellX) || !emptCell (cellY, cellX));
        gameField[cellY][cellX] = gamer; // если введены не верные координаты или клетка не пустая, выведет запрос координатов еще раз

    }

    // ход компьютера
    public static void aiTurn() {
        int cellX, cellY;
        do {
            System.out.println("Введите координаты клетки");
            cellX = random.nextInt(fieldSize); //указывается верхняя граница
            cellY = random.nextInt(fieldSize);
        } while (!emptCell (cellY, cellX));
        gameField[cellY][cellX] = ai;

    }

    /* проверка победы по двум диагоналям. для этого нужно одна переменная для каждой диагонали
    Каждую клеточку диагонали мы сравниваем с нашим символом и получаем результат (true) или (false).
    Затем делаем логическую операцию (&) между полученным результатом и нашей toright.
    Результат этой операции пишем опять в toright. Если на каком-то этапе мы получим результат (false),
    то все дальнейшие toright всегда будут равны (false).
     */
    public static boolean checkWinDiagonal (char player) {
        boolean toright; //записываем результат проверки слева сверху вправо вниз
        boolean toleft; //записываем результат проверки справа сверху влево вниз
        toright = true;
        toleft = true;
        for (int i = 0; i < dotWin; i++) {
            toright &= (gameField[i][i] == player);
            toleft &= (gameField[dotWin - i - 1][i] == player);

        }

        if (toright || toleft) return true; // Дальше мы вернули (true), если во всех клетках нам встретились символы player

        return false; // или вернули (false), если встретился хоть один символ, отличный от player
    }

    // Проверка победы по горизонтали и вертикали

    public static boolean checkWinLines (char player) {
        boolean cols, rows;
        for (int col = 0; col < dotWin; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < dotWin; row++) {
                cols &= (gameField[col][row] == player);
                rows &= (gameField[row][col] == player);
            }
            if (cols || rows) return true;
        }

        return false;
    }
    public static boolean fieldFull() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (gameField[i][j] == empt) return false;
            }
        }
        return true;
    }


    public static boolean cellValid(int cellY, int cellX) {
        return cellX >= 0 && cellX < fieldSize && cellY >= 0 && cellY < fieldSize; //если ввод в пределах поля true, иначе false
    }
    public static boolean emptCell (int cellY, int cellX) {
        return gameField[cellY][cellX] == empt; // если клетка пустая true, иначе false
    }

    public static void main (String[] args) {

        initGameField();
        printGameField();

        while (true){
         gamerTurn();
         printGameField();
         if (checkWinDiagonal(gamer) || checkWinLines(gamer)) {
             System.out.println("Игрок выиграл");
             break;
            }
         if (fieldFull()) {
             System.out.println("Ничья");
             break;
         }
         aiTurn();
         printGameField();
         if (checkWinDiagonal(ai) || checkWinLines(ai)) {
             System.out.println("Компьютер выиграл");
             break;
            }
         if (fieldFull()) {
             System.out.println("Ничья");
         }

        }

    }

}
