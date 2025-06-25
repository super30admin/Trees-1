// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class Problem2 {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        // Build a hashmap for quick index lookup in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        // No elements to construct the subtree
        if (left > right) return null;

        // Pick up preorderIndex element as the root
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Build left and right subtrees using inorder index boundaries
        int inorderIndex = inorderMap.get(rootVal);
        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}
