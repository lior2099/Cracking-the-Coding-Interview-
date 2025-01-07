package il.co.ilrd.book.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstCommonAncestorTest {

      /*
         1
       /  \
      2     3
     / \   / \
    4  5  6   7

     */
    private FirstCommonAncestor.TreeNode setupTree() {
        FirstCommonAncestor.TreeNode root = new FirstCommonAncestor.TreeNode(1);
        FirstCommonAncestor.TreeNode node2 = new FirstCommonAncestor.TreeNode(2);
        FirstCommonAncestor.TreeNode node3 = new FirstCommonAncestor.TreeNode(3);
        FirstCommonAncestor.TreeNode node4 = new FirstCommonAncestor.TreeNode(4);
        FirstCommonAncestor.TreeNode node5 = new FirstCommonAncestor.TreeNode(5);
        FirstCommonAncestor.TreeNode node6 = new FirstCommonAncestor.TreeNode(6);
        FirstCommonAncestor.TreeNode node7 = new FirstCommonAncestor.TreeNode(7);

        // Establish tree connections
        root.left = node2;
        root.right = node3;

        node2.parent = root;
        node2.left = node4;
        node2.right = node5;

        node3.parent = root;
        node3.left = node6;
        node3.right = node7;

        node4.parent = node2;
        node5.parent = node2;

        node6.parent = node3;
        node7.parent = node3;

        return root;
    }

    @Test
    void testCommonAncestor() {
        FirstCommonAncestor.TreeNode root = setupTree();
        FirstCommonAncestor.TreeNode node4 = root.left.left;
        FirstCommonAncestor.TreeNode node5 = root.left.right;

        FirstCommonAncestor.TreeNode ancestor = FirstCommonAncestor.getAncestorWithParent(node4, node5);
        assertEquals(root.left, ancestor); // Common ancestor of node4 and node5 is node2
    }

    @Test
    void testAncestorIsRoot() {
        FirstCommonAncestor.TreeNode root = setupTree();
        FirstCommonAncestor.TreeNode node4 = root.left.left;
        FirstCommonAncestor.TreeNode node7 = root.right.right;

        FirstCommonAncestor.TreeNode ancestor = FirstCommonAncestor.getAncestorWithParent(node4, node7);
        assertEquals(root, ancestor); // Common ancestor of node4 and node7 is root
    }

    @Test
    void testSameNodeAncestor() {
        FirstCommonAncestor.TreeNode root = setupTree();
        FirstCommonAncestor.TreeNode node4 = root.left.left;

        FirstCommonAncestor.TreeNode ancestor = FirstCommonAncestor.getAncestorWithParent(node4, node4);
        assertEquals(node4, ancestor); // The common ancestor of the same node is the node itself
    }

    @Test
    void testNodeWithNullParent() {
        FirstCommonAncestor.TreeNode root = setupTree();
        FirstCommonAncestor.TreeNode node4 = root.left.left;
        FirstCommonAncestor.TreeNode nodeNull = new FirstCommonAncestor.TreeNode(10);

        FirstCommonAncestor.TreeNode ancestor = FirstCommonAncestor.getAncestorWithParent(node4, nodeNull);
        assertNull(ancestor); // One node is disconnected, so no common ancestor
    }

    @Test
    void testNullNodes() {
        FirstCommonAncestor.TreeNode ancestor = FirstCommonAncestor.getAncestorWithParent(null, null);
        assertNull(ancestor); // Null nodes have no ancestor
    }
}
