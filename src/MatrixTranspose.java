import java.util.Random;
import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. Введення розміру квадратної матриці
        System.out.print("Введіть розмірність квадратної матриці (n x n): ");
        int size = scanner.nextInt();

        if (size < 1) {
            System.out.println("Розмір матриці повинен бути 1 або більше.");
            return;
        }

        int[][] matrix = new int[size][size];

        // 2. Заповнення матриці випадковими значеннями
        System.out.println("Згенерована матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(20) - 10; // Випадкові числа від -10 до 9
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        // 3. Обчислення транспонованої матриці
        int[][] transposedMatrix = transpose(matrix);

        // 4. Виведення транспонованої матриці
        System.out.println("\nТранспонована матриця:");
        printMatrix(transposedMatrix);

        scanner.close();
    }

    // Метод для транспонування матриці
    private static int[][] transpose(int[][] matrix) {
        int size = matrix.length;
        int[][] transposed = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[j][i] = matrix[i][j]; // Міняємо місцями рядки та стовпці
            }
        }
        return transposed;
    }

    // Метод для виводу матриці
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}

