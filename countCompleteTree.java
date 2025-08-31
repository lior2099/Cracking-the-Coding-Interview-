public class countCompleteTree {
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

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root , 0);
        int rightHeight = getHeight(root , 1);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private static int getHeight(TreeNode node, int way) {
        int height = 0;

        if (way == 0) {
            while (node != null) {
                height++;
                node = node.left;
            }
        } else {
            while (node != null) {
                height++;
                node = node.right;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);


        System.out.println(countNodes(root));
    }
}
