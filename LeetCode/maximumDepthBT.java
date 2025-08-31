package LeetCode;

public class maximumDepthBT {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;

        res = Math.max(maxDepth(root.left), res) ;
        res = Math.max(maxDepth(root.right), res) ;

        res++;
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(maxDepth(root));
    }
}
