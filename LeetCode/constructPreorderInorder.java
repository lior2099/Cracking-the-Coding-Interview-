package LeetCode;

import java.util.*;

public class constructPreorderInorder {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0)
            return null;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode node = new TreeNode(val);

            if (inorderMap.get(val) < inorderMap.get(stack.peek().val)) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && inorderMap.get(val) > inorderMap.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node);
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
        int[] preorder = {3,9,20,15,7};
        int[] inorder =  {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        printLevelOrder(root);
    }
}
