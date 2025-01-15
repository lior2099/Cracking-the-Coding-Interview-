package tree;

public class FirstCommonAncestor {
    /*
    First Common Ancestor: Design an algorithm and write code to find the first common ancestor
    of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
    necessarily a binary search tree.
     */


    public static TreeNode getAncestorWithParent(TreeNode node1, TreeNode node2) {
        TreeNode deepNode;
        TreeNode lessDeepNode;

        int dep1 = getDep(node1);
        int dep2 = getDep(node2);

        int lvlDep = dep1 - dep2;

        if (lvlDep > 0 ){
            deepNode = balanceLevel(node1 , lvlDep);
            lessDeepNode = node2;
        } else {
            deepNode = balanceLevel(node2 , -lvlDep);
            lessDeepNode = node1;
        }

        while (deepNode != null && lessDeepNode != null && deepNode != lessDeepNode){
            deepNode = deepNode.parent;
            lessDeepNode = lessDeepNode.parent;
        }

        return (deepNode == null || lessDeepNode == null) ? null : deepNode ;
    }

    public static TreeNode getAncestorNoParent(TreeNode root , TreeNode node1 , TreeNode node2){


        return null;
    }


    private static TreeNode balanceLevel(TreeNode node , int lvl){
        while (node != null && lvl > 0){
            node = node.parent;
            lvl--;
        }
        return node;
    }

    private static int getDep(TreeNode node) {
        int counter = 0;

        while (node != null){
            node = node.parent;
            counter++;
        }

        return counter;
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