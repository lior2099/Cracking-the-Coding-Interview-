package Recursion;

public class PaintFill {
    /*
    Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
    That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
    fill in the surrounding area until the color changes from the original color.
     */

    public enum Color {BLACK, RED, BLUE, GREEN, YELLOW, ORANGE}

    public static void paintAreaFill(Color[][] screen, int row, int col, Color newColor) {
        if (!isVald(screen, row, col) || screen[row][col] == newColor) {
            return;
        }
        paintAllArea(screen, row, col, newColor, screen[row][col]);
    }

    private static void paintAllArea(Color[][] screen, int row, int col, Color newColor, Color oldColer) {
        if (!isVald(screen, row ,col)){
            return ;
        }

        if (screen[row][col] == oldColer){
            screen[row][col] = newColor;
            paintAllArea(screen , row + 1 , col , newColor , oldColer); //up
            paintAllArea(screen , row - 1 , col , newColor , oldColer); // down
            paintAllArea(screen , row , col + 1 , newColor , oldColer); // right
            paintAllArea(screen , row , col - 1 , newColor , oldColer); // left
        }

    }

    private static boolean isVald(Color[][] screen, int row, int col) {
        return row >= 0 && row < screen.length && col >= 0 && col < screen[0].length;
    }
}

