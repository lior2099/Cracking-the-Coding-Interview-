package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /*
        Power Set: Write a method to return all subsets of a set.
     */

    // Entry point for generating power set with start and end indices
    public static List<List<Integer>> getSubsets2(List<Integer> set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        generateSubsets2(set, 0, set.size(), new ArrayList<>(), powerSet);
        return powerSet;
    }

    // Recursive function to generate subsets
    private static void generateSubsets2(List<Integer> set, int start, int end, List<Integer> current, List<List<Integer>> powerSet) {
        // Add the current subset to the power set
        powerSet.add(new ArrayList<>(current));

        // Iterate through the set and recursively add elements
        for (int i = start; i < end; i++) {
            current.add(set.get(i)); // Include the current element
            generateSubsets2(set, i + 1, end, current, powerSet); // Recurse to the next element
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        List<Integer> set = List.of(1, 2, 3);
        List<List<Integer>> subsets = getSubsets2(set);
        System.out.println(subsets);
    }
}
