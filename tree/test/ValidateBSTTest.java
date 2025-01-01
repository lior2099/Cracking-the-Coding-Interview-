package il.co.ilrd.book.tree.test;

import il.co.ilrd.book.tree.ValidateBST;
import il.co.ilrd.book.tree.ValidateBST.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBSTTest {

    @Test
    void testNullTree() {
        Assertions.assertTrue(ValidateBST.isBST(null), "An empty tree should be a valid BST.");
    }

    @Test
    void testSingleNodeTree() {
        TreeNode root = new TreeNode(10);
        assertTrue(ValidateBST.isBST(root), "A single-node tree should be a valid BST.");
    }

    @Test
    void testValidBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        assertTrue(ValidateBST.isBST(root), "The tree is a valid BST.");
    }

    @Test
    void testInvalidBSTLeftChild() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15); // Invalid
        root.right = new TreeNode(20);
        assertFalse(ValidateBST.isBST(root), "The tree is not a valid BST because the left child is greater than the root.");
    }

    @Test
    void testInvalidBSTRightChild() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5); // Invalid
        assertFalse(ValidateBST.isBST(root), "The tree is not a valid BST because the right child is not greater than the root.");
    }

    @Test
    void testOkBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(18);

        root.right.right = new TreeNode(30);


        assertTrue(ValidateBST.isBST(root), "The tree is valid BST.");
    }

    @Test
    void testNotBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(30);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(18);

        root.right.right = new TreeNode(30);


        assertFalse(ValidateBST.isBST(root), "The tree is valid BST.");
    }
}
