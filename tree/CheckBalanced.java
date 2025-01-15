package tree;

public class CheckBalanced {

    /*
        Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
        this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
        node never differ by more than one.
     */

    public static boolean isBalanced(TreeNode root){

        if (isBalancedHelper(root) == Integer.MIN_VALUE){
            return false;
        } else {
            return true;
        }
    }

    private static int isBalancedHelper(TreeNode curr){
        if (curr == null){
            return 0;
        }

        int left = isBalancedHelper(curr.left);
        if (left == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        int right = isBalancedHelper(curr.right);
        if (Math.abs(Math.abs(left) - Math.abs(right))  >1){
            return Integer.MIN_VALUE;
        }

        return Math.max(right,left) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
//        root.left.left.left = new TreeNode(2);
//        root.left.left.left.left = new TreeNode(1);

        root.right =new TreeNode(10);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(31);
        root.right.right.right = new TreeNode(33);
//        root.right.right.right.right = new TreeNode(34);

        System.out.println(isBalanced(root));
    }
}
