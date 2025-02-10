import java.util.Random;

public class MatrixSquareRoot {
    public static void main(String[] args) {
        int rows = 5; // Кількість рядків
        int cols = 5; // Кількість стовпців

        double[][] matrix = new double[rows][cols];
        Random random = new Random();

        // 1. Заповнення матриці випадковими числами від 1.0 до 100.0
        System.out.println("Оригінальна матриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1 + random.nextDouble() * 99; // Генеруємо число [1.0, 100.0]
                System.out.printf("%8.2f ", matrix[i][j]); // Вивід із двома знаками після крапки
            }
            System.out.println();
        }

        // 2. Обробка елементів з непарними індексами
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 || j % 2 != 0) { // Непарний індекс рядка або стовпця
                    matrix[i][j] = Math.sqrt(matrix[i][j]);
                }
            }
        }

        // 3. Вивід зміненої матриці
        System.out.println("\nМодифікована матриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f ", matrix[i][j]); // Вивід оновленої матриці
            }
            System.out.println();
        }
    }
}

