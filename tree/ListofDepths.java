package il.co.ilrd.book.tree;

import java.util.LinkedList;

public class ListofDepths {

    /*
        List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
        at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static LinkedList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
        LinkedList<LinkedList<TreeNode>> list = new LinkedList<>();
        fillListByDepths(root, list, 0);

        return list;
    }

    private static void fillListByDepths(TreeNode curr, LinkedList<LinkedList<TreeNode>> list, int level) {
        if (curr == null){
            return;
        }

        LinkedList<TreeNode> levelList = null;

        if (list.size() == level){
            levelList = new LinkedList<>();
            list.add(levelList);
        } else {
            levelList = list.get(level);
        }
        levelList.add(curr);
        fillListByDepths(curr.left , list , level +1);
        fillListByDepths(curr.right , list , level +1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        root.right =new TreeNode(10);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(31);

        LinkedList<LinkedList<TreeNode>> PintList = getListOfDepths(root);

        int i = 0 ;

        for (LinkedList<TreeNode> treeNodeLinkedList : PintList){
            for (TreeNode node : treeNodeLinkedList){
                System.out.print(node.val);
                System.out.print(" ");
            }
            System.out.println(" : -- " + i++);
        }

    }
}
