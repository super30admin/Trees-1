/*
 * Approach 1:
 *     Time Complexity: O(n^2) : as we are visiting each node and at each node we are doing linear search in inorder array.
 *     Space Complexity: O(n) : as the stack space is O(n) in the worst case when tree is skewed.
 * 
 * Approach 2:
 *    Time Complexity: O(n) : as we are visiting each node.
 *    Space Complexity: O(n) : as the hashmap space is O(n) + stack space is O(n) in the worst case when tree is skewed.
 * 
 * where n represents total number of nodes in a binary tree
 */

import java.util.*;

class TreeNode {
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

/*
 * Approach 1
 */
public class LC105 {
    int preIdx = 0;

    private int findMid(int[] inorder, int s, int e, int tar) {
        for (int i = s; i <= e; i++) {
            if (inorder[i] == tar)
                return i;
        }
        return -1;
    }

    private TreeNode build(int[] preorder, int[] inorder, int s, int e) {
        if (s > e)
            return null;
        int currPreVal = preorder[preIdx++];
        int mid = findMid(inorder, s, e, currPreVal);
        TreeNode root = new TreeNode(currPreVal);
        root.left = build(preorder, inorder, s, mid - 1);
        root.right = build(preorder, inorder, mid + 1, e);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
}

/*
 * Approach 2
 */
class LC105_2 {
    int preIdx = 0;

    private TreeNode build(int[] preorder, int[] inorder, int s, int e, HashMap<Integer, Integer> map) {
        if (s > e)
            return null;
        int currPreVal = preorder[preIdx++];
        int mid = map.get(currPreVal);
        TreeNode root = new TreeNode(currPreVal);
        root.left = build(preorder, inorder, s, mid - 1, map);
        root.right = build(preorder, inorder, mid + 1, e, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, map);
    }
}