import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We traverse the "preorder" array and create root Nodes as per it.
// Important thing here is to find left and right child of that node
// To find this we use "inorder" array - 
// left node: current node's index - 1
// right node: current node's index + 1
// To read n=value and index in O(1) time we use hashmap. Converting inorder into (value -> index) hashmap
class Solution2 {
    int preorderIndex;

    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;

        // build value -> index hashmap
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int left, int right) {
        // out of bounds, no more elements to process
        if (left > right)
            return null;

        // construct a root node
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // recursively construct left and right subtree
        root.left = buildSubTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = buildSubTree(preorder, inorderMap.get(rootValue) + 1, right);

        return root;
    }
}