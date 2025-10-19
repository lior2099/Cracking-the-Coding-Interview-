package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class constructInorderPostorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;

        int inIdx = inorder.length - 1;
        int postIdx = postorder.length - 1;

        TreeNode root = new TreeNode(postorder[postIdx--]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (postIdx >= 0) {
            TreeNode node = new TreeNode(postorder[postIdx]);
            TreeNode parent = null;

            while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
                parent = stack.pop();
                inIdx--;
            }

            if (parent != null) {
                parent.left = node;
            } else {
                stack.peek().right = node;
            }

            stack.push(node);
            postIdx--;
        }

        return root;
    }


    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.print((cur != null ? cur.val : "null") + " ");
            if (cur != null) {
                q.add(cur.left);
                q.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);
        printLevelOrder(root);


    }
}
