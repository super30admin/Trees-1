// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 *
 */

// Your code here along with comments explaining your approach
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, Integer> inMap;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        // return helperBruteForce(preorder, inorder);
        return helperoptimized(preorder, -1, 0, n - 1, n);

    }

    private TreeNode helperoptimized(int[] preorder, int rootIdx, int inStrtIdx, int inEndIdx, int n) {

        if (inStrtIdx > inEndIdx) {
            return null;
        }

        int element = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(element);
        rootIdx = inMap.get(element);

        root.left = helperoptimized(preorder, rootIdx, inStrtIdx, rootIdx - 1, n);
        root.right = helperoptimized(preorder, rootIdx, rootIdx + 1, inEndIdx, n);

        return root;
    }

    private TreeNode helperBruteForce(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }
        
        int rootElement = preorder[0];
        TreeNode root = new TreeNode(rootElement);
        int rootInOrIdx = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootElement) {
                rootInOrIdx = i;
                break;
            }
        }

        int inLeft[] = Arrays.copyOfRange(inorder, 0, rootInOrIdx);
        int inRight[] = Arrays.copyOfRange(inorder, rootInOrIdx + 1, inorder.length);

        int preLeft[] = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int preRightt[] = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

        root.left = helperBruteForce(preLeft, inLeft);
        root.right  = helperBruteForce(preRightt, inRight);

        return root;
    }
}