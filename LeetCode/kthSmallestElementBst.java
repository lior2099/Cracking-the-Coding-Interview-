package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class kthSmallestElementBst {
    private int count = 0;
    private int result = -1;

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int KthSmallestRecursive (TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    public static int KthSmallestIterative (TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }

        return -1;
    }

    public static int KthSmallestMorris (TreeNode root, int k) {
        int count = 0;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) return curr.val;
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    if (count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        long start, end;

        start = System.nanoTime();
        int res1 = new kthSmallestElementBst().KthSmallestRecursive(root, k);
        end = System.nanoTime();
        System.out.println("Recursive: " + res1 + " (" + (end - start) + " ns)");

        start = System.nanoTime();
        int res2 = KthSmallestIterative(root, k);
        end = System.nanoTime();
        System.out.println("Iterative: " + res2 + " (" + (end - start) + " ns)");

        start = System.nanoTime();
        int res3 = KthSmallestMorris(root, k);
        end = System.nanoTime();
        System.out.println("Morris: " + res3 + " (" + (end - start) + " ns)");

    }
}
