package Recursion;

import java.util.Arrays;
import java.util.Comparator;

class Box {
    int width, height, depth;

    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    boolean canBeAbove(Box other) {
        return this.width < other.width && this.height < other.height && this.depth < other.depth;
    }
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box b1, Box b2) {
        return b2.height - b1.height;
    }
}


public class StackOfBoxes {
    public static int maxStackHeight(Box[] boxes) {
        Arrays.sort(boxes, new BoxComparator());
        int n = boxes.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, maxStackHeightHelper(boxes, i, memo));
        }

        return maxHeight;
    }

    private static int maxStackHeightHelper(Box[] boxes, int index, int[] memo) {
        if (memo[index] != -1) return memo[index];

        Box bottom = boxes[index];
        int maxHeight = bottom.height;

        for (int i = index + 1; i < boxes.length; i++) {
            if (boxes[i].canBeAbove(bottom)) {
                maxHeight = Math.max(maxHeight, bottom.height + maxStackHeightHelper(boxes, i, memo));
            }
        }

        memo[index] = maxHeight;
        return maxHeight;
    }

    public static void main(String[] args) {
        Box[] boxes = {
                new Box(4, 10, 4),
                new Box(1, 2, 1),
                new Box(3, 6, 3),
                new Box(2, 3, 2),
                new Box(2, 3, 2),
                new Box(4, 3, 3)
        };

        System.out.println("Max Stack Height: " + maxStackHeight(boxes)); // Output the maximum height
    }
}
