package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RobotInAGrid {

    /*/
        Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
        The robot can only move in two directions, right and down, but certain cells are "off limits" such that
        the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
        the bottom right.
     */

    public static ArrayList<Point> getPath(int[][] grid) {
        ArrayList<Point> arrayList = new ArrayList<>();

        fildPath(grid, grid.length - 1, grid[0].length - 1, new Point(0, 0), arrayList);
        return arrayList;
    }

    private static boolean fildPath(int[][] grid, int rows, int colums, Point curr, ArrayList<Point> array) {
        if (rows < curr.row || colums < curr.col || grid[curr.row][curr.col] == -1) {
            return false;
        }

        array.add(curr);

        if (rows == curr.row && colums == curr.col) {
            return true;
        }

        boolean right = false;
        boolean bot = false;

        if (fildPath(grid, rows, colums, new Point(curr.row, curr.col + 1), array)) {
            right = true;
        } else if (fildPath(grid, rows, colums, new Point(curr.row + 1, curr.col), array)) {
            bot = true;
        } else {
            array.remove(curr);
            return false;
        }
        return true;
    }


    public static ArrayList<Point> getPathCashe(int[][] grid) {
        ArrayList<Point> arrayList = new ArrayList<>();
        HashSet<Point> failePoint = new HashSet<>();

        fildPathCashe(grid, grid.length - 1, grid[0].length - 1, new Point(0, 0), arrayList, failePoint);
        return arrayList;
    }

    private static boolean fildPathCashe(int[][] grid, int rows, int colums, Point curr, ArrayList<Point> array, HashSet<Point> visit) {
        if (rows < curr.row || colums < curr.col || grid[curr.row][curr.col] == -1) {
            return false;
        }

        if (visit.contains(curr)) {
            return false;
        }

        array.add(curr);

        if (rows == curr.row && colums == curr.col) {
            return true;
        }

        if (fildPathCashe(grid, rows, colums, new Point(curr.row, curr.col + 1), array, visit) ||
                fildPathCashe(grid, rows, colums, new Point(curr.row + 1, curr.col), array, visit)) {
            return true;
        }
        array.remove(curr);
        visit.add(curr);
        return false;
    }


    public static class Point {
        int row, col;

        public Point(int x, int y) {
            this.row = x;
            this.col = y;
        }

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, -1, 0},
                {0, -1, 0, 0},
                {0, -1, 0, 0},
                {0, 0, 0, 0}
        };
        int[][] grid2 = {
                {0, 0, 0, -1, -1, -1, -1},
                {0, -1, 0, -1, -1, -1, -1},
                {0, -1, 0, 0, 0, -1, -1},
                {0, -1, -1, -1, 0, -1, -1},
                {0, 0, 0, 0, 0, -1, -1},
                {-1, -1, -1, -1, 0, -1, -1},
                {-1, -1, -1, -1, 0, 0, 0}
        };

        int[][] largeGrid = new int[20][20];
        // Fill the grid with open cells (0)
        for (int i = 0; i < 20; i++) {
            Arrays.fill(largeGrid[i], 0);
        }
        // Introduce blocked cells (-1)
        for (int i = 1; i < 20; i++) {
            largeGrid[i][i - 1] = -1; // Diagonal blocking
        }
        for (int i = 0; i < 10; i++) {
            largeGrid[15][i] = -1; // Horizontal blocking
        }

        ArrayList<Point> arrays = null;
        ArrayList<Point> arraysCahse = null;

        System.out.println("\n==== Grid 1 ====");

//         Warm-up phase
        for (int i = 0; i < 5; i++) {
            arrays = getPath(grid);
            arraysCahse = getPathCashe(grid);
        }


        testGrid(grid);

        System.out.println("\n==== Grid 2 ====");

//        Warm-up phase
        for (int i = 0; i < 5; i++) {
            arrays = getPath(grid2);
            arraysCahse = getPathCashe(grid2);
        }

        testGrid(grid2);


        System.out.println("\n==== Large Grid (20x20) ====");
        //        Warm-up phase
        for (int i = 0; i < 3; i++) {
            arrays = getPath(largeGrid);
            arraysCahse = getPathCashe(largeGrid);
        }

        testGrid(largeGrid);

    }

    private static void testGrid(int[][] grid) {
        long startTime;
        long endTime;

        ArrayList<Point> arrays;
        ArrayList<Point> arraysCahse;

        // Test without caching
        startTime = System.nanoTime();
        arrays = getPath(grid);
        endTime = System.nanoTime();
        System.out.println("Without Cache = Time: " + (endTime - startTime) + " nanoseconds");
        arrays.forEach(point -> System.out.print("(" + point.row + ", " + point.col + ") "));
        System.out.println();

        // Test with caching
        startTime = System.nanoTime();
        arraysCahse = getPathCashe(grid);
        endTime = System.nanoTime();
        System.out.println("With Cache = Time: " + (endTime - startTime) + " nanoseconds");
        arraysCahse.forEach(point -> System.out.print("(" + point.row + ", " + point.col + ") "));
        System.out.println();
    }

}
