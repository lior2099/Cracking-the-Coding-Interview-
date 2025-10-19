import java.util.ArrayDeque;
import java.util.Deque;


public class flattenBinaryTreeToLinkedList {
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


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> Q = new ArrayDeque<>();
        TreeNode cur;
        TreeNode pre = new TreeNode(0);

        Q.push(root);
        while (!Q.isEmpty()) {
            cur = Q.pop();
            if (cur.right != null) {
                Q.push(cur.right);
            }
            if (cur.left != null) {
                Q.push(cur.left);
            }
            pre.right = cur;
            pre.left = null;
            pre = cur;

        }

    }

    public static void flatten2(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {

                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;


                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+ " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        printTree(root);

//        flattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new flattenBinaryTreeToLinkedList();
//        flattenBinaryTreeToLinkedList.flatten(root);

        flatten2(root);

        printTree(root);

    }

}
