package tree;

public class Successor {
    /*
        Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
        binary search tree. You may assume that each node has a link to its parent.
     */

    public static TreeNode findNextNode(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.right != null){
            return allLeft(node.right);
        }

        return findParent(node , node.parent);
    }

    private static TreeNode allLeft(TreeNode node){
        while (node.left != null){
            node = node.left;
        }

        return node;
    }

    private static TreeNode findParent(TreeNode node , TreeNode parent){
        if (parent == null){
            return null;
        }
        if (parent.left == node){
            return parent;
        }
        return findParent(parent , parent.parent);
    }

    public static class TreeNode {
        public int val;
        public TreeNode parent;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }


    }
}
