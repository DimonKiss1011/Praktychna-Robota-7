import java.util.Scanner;

public class MatrixDeterminant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 5; // Розмір матриці 5x5
        int[][] matrix = new int[size][size];

        // 1. Введення матриці користувачем
        System.out.println("Введіть елементи матриці 5x5:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 2. Виведення введеної матриці
        System.out.println("\nВведена матриця:");
        printMatrix(matrix);

        // 3. Обчислення визначника
        int determinant = calculateDeterminant(matrix);
        System.out.println("\nВизначник матриці: " + determinant);

        scanner.close();
    }

    // Метод для виводу матриці
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d ", num);
            }
            System.out.println();
        }
    }

    // Метод для обчислення визначника рекурсивно
    private static int calculateDeterminant(int[][] matrix) {
        int size = matrix.length;

        // Базовий випадок для 2x2 матриці
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int i = 0; i < size; i++) {
            int[][] subMatrix = getSubMatrix(matrix, i);
            determinant += matrix[0][i] * calculateDeterminant(subMatrix) * (i % 2 == 0 ? 1 : -1);
        }

        return determinant;
    }

    // Метод для отримання мінору (підматриці)
    private static int[][] getSubMatrix(int[][] matrix, int excludedColumn) {
        int size = matrix.length;
        int[][] subMatrix = new int[size - 1][size - 1];

        for (int i = 1; i < size; i++) {
            int subColIndex = 0;
            for (int j = 0; j < size; j++) {
                if (j == excludedColumn) continue;
                subMatrix[i - 1][subColIndex++] = matrix[i][j];
            }
        }
        return subMatrix;
    }
}

