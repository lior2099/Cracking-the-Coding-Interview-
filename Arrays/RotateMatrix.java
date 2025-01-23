package Arrays;

public class RotateMatrix {
    /*
        Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
        bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     */

    public static void rotateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length ) {
            return;
        }
        int n = matrix.length;

        for (int i = 0; i < n /2 ; i++) {
            int first = i;
            int last = n - i - 1;

            for (int j = first; j < last ; j++) {
                int offset = j - first;

                //save top as temp
                int top = matrix[first][j];

                //move left to top
                matrix[first][j] = matrix[last-offset][first];

                //move bot to left
                matrix[last-offset][first] = matrix[last][last-offset];

                //move right to bot
                matrix[last][last-offset] = matrix[j][last];

                //move top to right
                matrix[j][last] = top;

            }
        }



    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4,5}, {6,7,8,9,10}, {11,12,13,14,15} ,{16,17,18,19,20} , {21,22,23,24,25} };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        rotateMatrix(matrix);

        System.out.println("\nafter rotate matrix\n");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
