package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class insertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null ) return new int[0][0];

        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }


        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][]  intervals = new int[][]{{1,3},{6,9}};
        int[]  postorder = new int[]{2,5};

        int[][] result = insert(intervals, postorder);

        for (int[] i : result) {
            System.out.print("[" + i[0] + " ," + i[1] + "]");
            System.out.print(" ");
        }
        System.out.println(" ");

        int[][]  intervals2 = new int[][]{{1,2},{3,5}, {6,7}, {8,10} , {12,16}};
        int[]  newint = new int[]{4,8};

        int[][]  result2 = insert(intervals2, newint);
        for (int[] i : result2) {
            System.out.print("[" + i[0] + " ," + i[1] + "]");
            System.out.print(" ");
        }
    }
}
