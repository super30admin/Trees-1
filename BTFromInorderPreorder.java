// Approach: The first element of the preorder traversal is always the root. Find the index of this element in the inorder traversal.
// All elements to the left of this index form the left subtree, and all elements to the right form the right subtree. Recursively
// construct the entire tree while keeping track of the start and end indices of the preorder and inorder traversals for each subtree.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.Map;
import java.util.HashMap;

public class BTFromInorderPreorder {
    Map<Integer, Integer> inMap;

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int v) {
            val = v;
        }
    }

    TreeNode construct(int[] inorder, int[] preorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdxInorder = inMap.get(preorder[preStart]);
        int leftSubtreeNodeCount = rootIdxInorder - inStart;
        root.left = build(inorder, inStart, rootIdxInorder - 1, preorder, preStart + 1, preStart + leftSubtreeNodeCount);
        root.right = build(inorder, rootIdxInorder + 1, inEnd, preorder, preStart + leftSubtreeNodeCount + 1, preEnd);
        return root;
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        BTFromInorderPreorder bfip = new BTFromInorderPreorder();
//      preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] inorder = { 9,3,15,20,7 };
        int[] preorder = { 3,9,20,15,7 };
        TreeNode root = bfip.construct(inorder, preorder);
        bfip.preorder(root); // prints 3,9,20,15,7
    }
}