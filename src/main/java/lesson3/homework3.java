package lesson3;

import java.util.Random;
import java.util.Scanner;

public class homework3 {
    public static char[][] gameField;
    public static int fieldSize = 5;
    public static int dotWin = 4;
    public static char gamer = 'X';
    public static char ai = '0';
    public static char empt = '*';
    public static Scanner scanner;
    public static Random random;

    public homework3() {
    }

    public static void initGameField() {
        gameField = new char[fieldSize][fieldSize];

        for(int i = 0; i < fieldSize; ++i) {
            for(int j = 0; j < fieldSize; ++j) {
                gameField[i][j] = empt;
            }
        }

    }

    public static void printGameField() {
        for(int i = 0; i < fieldSize; ++i) {
            for(int j = 0; j < fieldSize; ++j) {
                System.out.print(gameField[i][j] + " | ");
            }

            System.out.println();
        }

        System.out.println("--------------------");
    }

    public static void gamerTurn() {
        int cellX;
        int cellY;
        do {
            System.out.println("Введите координаты клетки");
            cellX = scanner.nextInt() - 1;
            cellY = scanner.nextInt() - 1;
        } while(!cellValid(cellY, cellX) || !emptCell(cellY, cellX));

        gameField[cellY][cellX] = gamer;
    }

    public static void aiTurn() {
        int cellX;
        int cellY;
        do {
            System.out.println("Введите координаты клетки");
            cellX = random.nextInt(fieldSize);
            cellY = random.nextInt(fieldSize);
        } while(!emptCell(cellY, cellX));

        gameField[cellY][cellX] = ai;
    }

    public static boolean checkWinDiagonal(char player) {
        boolean toright = true;
        boolean toleft = true;

        for(int i = 0; i < dotWin; ++i) {
            toright &= gameField[i][i] == player;
            toleft &= gameField[dotWin - i - 1][i] == player;
        }

        if (!toright && !toleft) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkWinLines(char player) {
        for(int col = 0; col < dotWin; ++col) {
            boolean cols = true;
            boolean rows = true;

            for(int row = 0; row < dotWin; ++row) {
                cols &= gameField[col][row] == player;
                rows &= gameField[row][col] == player;
            }

            if (cols || rows) {
                return true;
            }
        }

        return false;
    }

    public static boolean fieldFull() {
        for(int i = 0; i < fieldSize; ++i) {
            for(int j = 0; j < fieldSize; ++j) {
                if (gameField[i][j] == empt) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean cellValid(int cellY, int cellX) {
        return cellX >= 0 && cellX < fieldSize && cellY >= 0 && cellY < fieldSize;
    }

    public static boolean emptCell(int cellY, int cellX) {
        return gameField[cellY][cellX] == empt;
    }

    public static void main(String[] args) {
        initGameField();
        printGameField();

        while(true) {
            gamerTurn();
            printGameField();
            if (!checkWinDiagonal(gamer) && !checkWinLines(gamer)) {
                if (fieldFull()) {
                    System.out.println("Ничья");
                    break;
                }

                aiTurn();
                printGameField();
                if (!checkWinDiagonal(ai) && !checkWinLines(ai)) {
                    if (fieldFull()) {
                        System.out.println("Ничья");
                    }
                    continue;
                }

                System.out.println("Компьютер выиграл");
                break;
            }

            System.out.println("Игрок выиграл");
            break;
        }

    }

    static {
        scanner = new Scanner(System.in);
        random = new Random();
    }
}
