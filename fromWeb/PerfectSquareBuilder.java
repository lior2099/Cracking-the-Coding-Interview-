package fromWeb;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquareBuilder {

    public static void main(String[] args) {
        int line1 = 99; // Length of line 1
        int line2 = 1;  // Length of line 2

        int largestSquare = findLargestSquareSize(line1 + line2);
        System.out.println("Largest square size: " + largestSquare);

        List<Integer> line1Parts = splitLine(line1, largestSquare);
        List<Integer> line2Parts = splitLine(line2, largestSquare);

        System.out.println("Line 1 parts: " + line1Parts);
        System.out.println("Line 2 parts: " + line2Parts);

        int totalSquares = (line1 + line2) / (largestSquare * largestSquare);
        System.out.println("Total squares formed: " + totalSquares);
    }

    private static int findLargestSquareSize(int totalLength) {
        for (int size = (int) Math.sqrt(totalLength); size > 0; size--) {
            if (totalLength % (size * size) == 0) {
                return size;
            }
        }
        return 1; // Fallback if no larger square is possible
    }

    private static List<Integer> splitLine(int line, int squareSize) {
        List<Integer> parts = new ArrayList<>();
        while (line >= squareSize) {
            parts.add(squareSize);
            line -= squareSize;
        }
        if (line > 0) {
            parts.add(line);
        }
        return parts;
    }
}