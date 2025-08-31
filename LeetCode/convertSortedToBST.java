package LeetCode;

public class convertSortedToBST {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return addToBST(0, nums.length - 1, nums);  // Pass full range initially
    }

    private static TreeNode addToBST(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = addToBST(left, mid - 1, nums);
        cur.right = addToBST(mid + 1, right, nums);

        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        int[] nums2 = new int[]{0,1,2,3,4,5};

//        TreeNode root = sortedArrayToBST(nums);
//        preorder(root);
        System.out.println();
        TreeNode root2 = sortedArrayToBST(nums2);
        preorder(root2);


    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }
        System.out.print(root.val + " ");
        System.out.println();
        preorder(root.left);
        preorder(root.right);
    }
}

