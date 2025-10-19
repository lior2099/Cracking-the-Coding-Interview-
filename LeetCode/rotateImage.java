package LeetCode;

public class rotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int run = first; run < last; run++) {
                int offset = run - first;

                int top = matrix[first][run];

                matrix[first][run] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[run][last];

                matrix[run][last] = top;
            }
        }


    }


    public static void main(String[] args) {
        int[][] matrix = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };

        System.out.println("Original:");
        printMatrix(matrix);

        rotate(matrix);  // Your rotation function

        System.out.println("Rotated 90° Clockwise:");
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
        System.out.println();
    }
}
