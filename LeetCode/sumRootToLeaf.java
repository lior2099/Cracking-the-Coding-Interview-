package LeetCode;

public class sumRootToLeaf {
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

    public int sumNumbers(TreeNode root) {
        return sumRec(root, 0);
    }


    private int sumRec(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return sumRec(node.left, currentSum) + sumRec(node.right, currentSum);
    }

    public static void main(String[] args) {
        sumRootToLeaf root = new sumRootToLeaf();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        System.out.println(root.sumNumbers(node1));
    }
}
