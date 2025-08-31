package LeetCode;

public class setMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int[] rows =  new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int row = 0; row < rowLen; row++) {
            if (rows[row] > 0) {
                for (int col = 0; col < colLen; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 0; col < colLen; col++) {
            if (cols[col] > 0) {
                for (int row = 0; row < rowLen; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        int[][] matrix3 = {{0},{1}};
        setZeroes(matrix3);
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
