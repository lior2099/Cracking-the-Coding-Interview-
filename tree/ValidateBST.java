package tree;

public class ValidateBST {
    /*
    Validate BST: Implement a function to check if a binary tree is a binary search tree.
     */

    public static boolean isBST(TreeNode root){

        return isBSTRec(root,null,null);
    }


    private static boolean isBSTRec(TreeNode curr , TreeNode min , TreeNode max){
        if (curr == null){
            return true;
        }

        if ((min != null && min.val >= curr.val) || (max != null && max.val <= curr.val) ){
            return false;
        }

        if (curr.left != null && curr.left.val > curr.val || curr.right != null && curr.right.val < curr.val ){
            return false;
        }

        return isBSTRec(curr.left , min , curr) && isBSTRec(curr.right , curr , max);
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }


    }




}
