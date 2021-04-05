package homework;

import java.util.Arrays;

public class homework2 {
    public static void main (String[] args) {
        // Задание 1.
        int[] array1 = {1, 0, 0, 1, 1, 1, 0, 0};
       System.out.println("1. До:" + Arrays.toString(array1));
        changeNamber(array1);
        System.out.println("1. После:" + Arrays.toString(array1));

        // Задание 2.
        int [] arrInt = new int[8];
        fillingIn (arrInt);
        System.out.println("2. " + Arrays.toString(arrInt) );

        // Задание 3.
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. До: " + Arrays.toString(mas));
        doubling (mas);
        System.out.println("3. После: " + Arrays.toString(mas));

        // Задание 4.

        System.out.println("4. Максимальное: " + findMax(mas));
        System.out.println("4. Минимальное: " + findMin(mas));

        // Задание 5.

        int side = 3;
        int[][] dArr = new int[side][side];
        crossFill(dArr);
        printArraySize2(dArr);

        // Задание 6

        int[] shiftArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("6. " + Arrays.toString(shiftArray));
        shifter(shiftArray, -3);
        System.out.println("-5: " + Arrays.toString(shiftArray));
        shifter(shiftArray, 6);
        System.out.println("+5: " + Arrays.toString(shiftArray));


    }
    public static void changeNamber (int[] array) {
        for (int i = 0; i < array.length; i++ )
            array[i] = 1 - array[i];
    }
    public static void fillingIn (int[] array ) {
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3 + 1;
    }
    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) {
                array[i] *=2;
            }

    }
    public static int findMax (int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }
    public static int findMin (int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
    public static void crossFill (int[][] arr) {
        int lastIndexElement = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }
    public static void printArraySize2(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void shifter(int[] array, int value) {
        boolean direction;
        if (value < 0) {
            direction = true;
            value = -value;
        } else {
            direction = false;
        }
        value %= array.length;
        int lastIndex = array.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (direction) ? array[0] : array[lastIndex];
            for (int j = 0; j < lastIndex; j++) {
                if (direction)
                    array[j] = array[j + 1];
                else
                    array[lastIndex - j] = array[lastIndex - j - 1];
            }
            if (direction)
                array[lastIndex] = temp;
            else
                array[0] = temp;
        }
    }




}
