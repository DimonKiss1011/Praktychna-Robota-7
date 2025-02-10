import java.util.Random;
import java.util.Scanner;

public class MatrixMinor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. Введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці (n x n): ");
        int size = scanner.nextInt();

        if (size < 2) {
            System.out.println("Розмір матриці повинен бути 2 або більше.");
            return;
        }

        int[][] matrix = new int[size][size];

        // 2. Заповнення матриці випадковими значеннями
        System.out.println("Згенерована матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10); // Випадкові значення від 0 до 9
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 3. Вибір елемента для обчислення мінора
        System.out.print("\nВведіть номер рядка (0-" + (size - 1) + ") для видалення: ");
        int rowToRemove = scanner.nextInt();
        System.out.print("Введіть номер стовпця (0-" + (size - 1) + ") для видалення: ");
        int colToRemove = scanner.nextInt();

        // Перевірка введених значень
        if (rowToRemove < 0 || rowToRemove >= size || colToRemove < 0 || colToRemove >= size) {
            System.out.println("Невірні координати, спробуйте ще раз.");
            return;
        }

        // 4. Отримання мінора
        int[][] minorMatrix = getMinor(matrix, rowToRemove, colToRemove);

        // 5. Виведення мінора
        System.out.println("\nМінор матриці:");
        printMatrix(minorMatrix);

        scanner.close();
    }

    // Метод для отримання мінора
    private static int[][] getMinor(int[][] matrix, int rowToRemove, int colToRemove) {
        int newSize = matrix.length - 1;
        int[][] minor = new int[newSize][newSize];

        int r = 0, c;
        for (int i = 0; i < matrix.length; i++) {
            if (i == rowToRemove) continue; // Пропускаємо вибраний рядок
            c = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (j == colToRemove) continue; // Пропускаємо вибраний стовпець
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }

    // Метод для виводу матриці
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

