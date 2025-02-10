import java.util.Random;

public class JaggedPyramidArray {
    public static void main(String[] args) {
        int rows = 5; // Кількість рядків у піраміді
        int[][] pyramid = new int[rows][];

        Random random = new Random();

        // 1. Створення зубчастого масиву (піраміди)
        for (int i = 0; i < rows; i++) {
            pyramid[i] = new int[i + 1]; // Кожен наступний рядок довший за попередній
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = random.nextInt(100); // Генеруємо випадкові числа
            }
        }

        // 2. Вивід масиву у звичайному порядку (пірамідою)
        System.out.println("Піраміда у звичайному порядку:");
        printPyramid(pyramid);

        // 3. Вивід масиву у зворотному порядку
        System.out.println("\nПіраміда у зворотному порядку:");
        printReversedPyramid(pyramid);
    }

    // Метод для виводу піраміди у правильному порядку
    private static void printPyramid(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printSpaces(array.length - i);
            for (int num : array[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Метод для виводу піраміди у зворотному порядку
    private static void printReversedPyramid(int[][] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            printSpaces(array.length - i);
            for (int num : array[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Метод для відступів перед рядками
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}

