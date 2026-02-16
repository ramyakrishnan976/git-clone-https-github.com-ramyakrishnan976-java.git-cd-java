import java.util.Scanner;

class Matrix {
    private int rows, cols;
    private int[][] data;

    // Parameterized Constructor
    public Matrix(int r, int c) {
        this.rows = r;
        this.cols = c;
        this.data = new int[r][c];
    }

    // Method to get data from user
    public void getData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = sc.nextInt();
            }
        }
    }

    // Method to display matrix
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Unary Minus: -A
    public Matrix negate() {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = -this.data[i][j];
            }
        }
        return res;
    }

    // Addition: A + B
    public static Matrix add(Matrix A, Matrix B) {
        if (A.rows != B.rows || A.cols != B.cols) return null;
        Matrix res = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                res.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return res;
    }

    // Subtraction: A - B
    public static Matrix subtract(Matrix A, Matrix B) {
        if (A.rows != B.rows || A.cols != B.cols) return null;
        Matrix res = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < A.cols; j++) {
                res.data[i][j] = A.data[i][j] - B.data[i][j];
            }
        }
        return res;
    }

    // Multiplication: A * B
    public static Matrix multiply(Matrix A, Matrix B) {
        if (A.cols != B.rows) return null;
        Matrix res = new Matrix(A.rows, B.cols);
        for (int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.cols; j++) {
                for (int k = 0; k < A.cols; k++) {
                    res.data[i][j] += A.data[i][k] * B.data[k][j];
                }
            }
        }
        return res;
    }
}

public class MatrixTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dimension for square matrices (n x n): ");
        int n = sc.nextInt();

        Matrix A = new Matrix(n, n);
        Matrix B = new Matrix(n, n);

        System.out.println("Enter elements for Matrix A:");
        A.getData();

        System.out.println("Enter elements for Matrix B:");
        B.getData();

        // Evaluate R = (-A + B) - (A * B)
        
        // Part 1: (-A + B)
        Matrix negA = A.negate();
        Matrix part1 = Matrix.add(negA, B);

        // Part 2: (A * B)
        Matrix part2 = Matrix.multiply(A, B);

        // Part 3: R = Part 1 - Part 2
        if (part1 != null && part2 != null) {
            Matrix R = Matrix.subtract(part1, part2);

            System.out.println("\nResultant Matrix R [(-A + B) - (A * B)]:");
            R.display();
        } else {
            System.out.println("Error: Matrix dimensions incompatible for calculation.");
        }
        
        sc.close();
    }
}
