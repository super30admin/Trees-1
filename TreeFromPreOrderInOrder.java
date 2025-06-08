import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
// ---------------------------------- Solution 1 -------------------------------------
public class TreeFromPreOrderInOrder {
    /**
     * Logic is to take preorder first element as it will the current root and from inorder list find corresponding
     * index at which the same value occurs. take the left range from that inorder index and recursively build the left
     * subtree and do the same on the right side of range. With each recursion provide new int arrays for preorder
     * and postorder as it passes as reference which doesn't work with this solution
     *
     * TC: O(n^2) Auxiliary SC: O(n^2) at each node we are preparing new preorder and inorder arrays
     * Recursive stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    private TreeNode helper(int[] preorder, int[] inorder) {
        //base
        if (preorder.length == 0) {
            return null;
        }

        //logic
        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = -1;

        for(int i = 0 ; i < inorder.length; i++) { // O(n)
            if (root.val == inorder[i]) {
                rootIdx = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preleft = Arrays.copyOfRange(preorder, 1, 1 + inleft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inleft.length, preorder.length);

        root.left = helper(preleft, inleft);
        root.right = helper(preRight, inRight);
        return root;
    }
}

// ---------------------------------- Solution 2 -------------------------------------
class TreeFromPreOrderInOrder2 {
    /**
     * To improve on TC in previous solution add a hashmap to lookup index in inorder array in constant time.
     * Also copying new preorder and inorder arrays at each node took time and space in previous solution, so
     * use the same arrays with start and end pointers at each recursive call to retrieve needed range
     *
     * TC: O(n) Auxiliary SC: O(n) due to hashmap
     * Recursive stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    int preorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end) {
        //base
        if (start > end) {
            return null;
        }

        //logic
        TreeNode root = new TreeNode(preorder[preorderIdx++]);
        int inorderIdx = inorderMap.get(root.val);
        root.left = buildTree(preorder, inorderMap, start, inorderIdx - 1);
        root.right = buildTree(preorder, inorderMap, inorderIdx + 1, end);
        return root;
    }
}
