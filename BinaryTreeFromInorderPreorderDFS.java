// Time Complexity : O(2n) for 2 recursive calls => O(n)
// Space Complexity : O(n) => For storing the inorder[] in a hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. To figure out the base case
// left > right

/*
 * Approach: Start with storing the inorder[] in a hahmap with key as the
 * element and value as the index at which that element is stored. Then find the
 * root node from the preorder[] and calculate root's left and right child by
 * recursively calling arrayToTree() method
 */
class Solution {
    Map<Integer, Integer> map;
    int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        map = new HashMap<>();
        preOrderIndex = 0;

        // Store inorder array in a map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {

        // Example: when we try to look for left & right child of 9 which is at index 0
        // in inorder map, left becomes 0 & right becomes -1 & for right child left
        // becomes 1 and right becomes 0
        if (left > right) {
            return null;
        }

        // Fetch the root
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, map.get(rootValue) - 1);

        root.right = arrayToTree(preorder, map.get(rootValue) + 1, right);

        return root;
    }
}