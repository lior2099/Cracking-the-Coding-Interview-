package LeetCode;

import java.util.*;

public class findkPairsWithSmallest {

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        // Needed for use in HashSet
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Pair> seen = new HashSet<>();

        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        seen.add(new Pair(0, 0));

        while (!minHeap.isEmpty() && k-- > 0) {
            int[] top = minHeap.poll();
            int  i = top[1], j = top[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && seen.add(new Pair(i + 1, j))) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }

            if (j + 1 < nums2.length && seen.add(new Pair(i, j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        findkPairsWithSmallest ksp = new findkPairsWithSmallest();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> result = ksp.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
