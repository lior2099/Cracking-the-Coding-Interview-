package LeetCode;
import java.util.*;

public class mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < len && end >= intervals[i + 1][0] ) {
                end =  Math.max(end, intervals[i + 1][1]);
                i++;

            }
            res.add(new int[]{start, end});
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(input);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
