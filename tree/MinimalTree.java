package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimalTree {
    public static TreeNode getSortBST(int[] arr) {
        return buildTree(arr, 0, arr.length - 1);
    }

    private static TreeNode buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = ((end + start) / 2) ;
        TreeNode midNode = new TreeNode(arr[mid]);
        midNode.left = buildTree(arr, start, mid - 1);
        midNode.right = buildTree(arr, mid + 1, end);

        return midNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        int maxLevel = getTreeHeight(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Nodes at the current level
            boolean hasNonNull = false; // Track if this level contains non-null nodes
            int space = (int) Math.pow(2, maxLevel - level) - 1; // Dynamic spacing for tree visualization

            printSpaces(space);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    System.out.print(currentNode.val);
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                    if (currentNode.left != null || currentNode.right != null) {
                        hasNonNull = true; // Found a non-null child
                    }
                } else {
                    System.out.print(" ");
                    queue.add(null); // Add placeholders for null children
                    queue.add(null);
                }
                printSpaces(space * 2 + 1); // Spacing between nodes
            }
            System.out.println();

            if (!hasNonNull) {
                break; // Stop processing further levels if no non-null nodes exist
            }

            level++;
        }
    }

    // Helper method to calculate the height of the tree
    private static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    // Helper method to print spaces
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12};

        TreeNode treeNode = getSortBST(arr);
        printTree(treeNode);
    }
}