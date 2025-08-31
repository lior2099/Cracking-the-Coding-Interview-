package LeetCode;

public class gameOfLifeQ {
    public static void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;
        int livesNeighbors = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                livesNeighbors = sumLive(board, i, j);

                if (board[i][j] == 1) {
                    if (livesNeighbors < 2 || livesNeighbors > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (livesNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static int sumLive(int[][] board, int row, int col) {
        int lives = 0;
        int len_row = board.length;
        int len_col = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int check_row = row + i;
                int check_col = col + j;

                if (check_row >= 0 && check_row < len_row && check_col >= 0 &&
                        check_col < len_col && (board[check_row][check_col] == 1 || board[check_row][check_col] == -1)) {
                    lives++;
                }
            }
        }

        return lives;
    }

    public static void main(String[] args) {

        int[][] board = {{0,1,0}, {0,0,1},{1,1,1} , {0,0,0}};

        gameOfLife(board);

        int i = 0, j = 0;
        for (i  = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
