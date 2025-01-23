package Recursion;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    private static final int SIZE = 8; // Chessboard size

    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(SIZE);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println("Total Solutions: " + solutions.size());
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, result);
        return result;
    }

    private static void solve(int row, char[][] board, List<List<String>> result) {
        if (row == SIZE) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < SIZE; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}

