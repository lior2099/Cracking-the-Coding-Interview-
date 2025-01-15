package tree.test;

import tree.Successor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuccessorTest {


    /*
             20
           /  \
          10   30
         / \   /
        5  15 25


     */
    private Successor.TreeNode root;
    private Successor.TreeNode node10;
    private Successor.TreeNode node30;
    private Successor.TreeNode node5;
    private Successor.TreeNode node15;
    private Successor.TreeNode node25;

    @BeforeEach
    public void setupTree() {
        root = new Successor.TreeNode(20);
        node10 = new Successor.TreeNode(10);
        node30 = new Successor.TreeNode(30);
        node5 = new Successor.TreeNode(5);
        node15 = new Successor.TreeNode(15);
        node25 = new Successor.TreeNode(25);

        root.left = node10;
        root.right = node30;

        node10.parent = root;
        node30.parent = root;

        node10.left = node5;
        node10.right = node15;

        node5.parent = node10;
        node15.parent = node10;

        node30.left = node25;
        node25.parent = node30;
    }

    @Test
    public void testSmallestNode() {
        Successor.TreeNode result = Successor.findNextNode(node5);
        assertNotNull(result);
        assertEquals(10, result.val, "The successor of the smallest node should be 10.");
    }

    @Test
    public void testNodeWithRightSubtree() {
        Successor.TreeNode result = Successor.findNextNode(node10);
        assertNotNull(result);
        assertEquals(15, result.val, "The successor of node 10 should be 15.");
    }

    @Test
    public void testNodeWithoutRightSubtree() {
        Successor.TreeNode result = Successor.findNextNode(node15);
        assertNotNull(result);
        assertEquals(20, result.val, "The successor of node 15 should be 20.");
    }

    @Test
    public void testLargestNode() {
        Successor.TreeNode result = Successor.findNextNode(node30);
        assertNull(result, "The successor of the largest node should be null.");
    }

    @Test
    public void testRootNode() {
        Successor.TreeNode result = Successor.findNextNode(root);
        assertNotNull(result);
        assertEquals(25, result.val, "The successor of the root node should be 25.");
    }

}
