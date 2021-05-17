/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class PreInOrder {
    int idx;
    Map<Integer, Integer> hmap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        // build a hashmap to store value -> its index relations
        hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
     
        if (left > right) return null; // check if no elements

       
        int rootValue = preorder[idx++];  // select the preorder_index element as the root and increment it
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
       
        root.left = helper(preorder, left, hmap.get(rootValue) - 1);  // excluding inorderIndexMap[rootValue] element because it's the root
        root.right = helper(preorder, hmap.get(rootValue) + 1, right);
        return root;
    }
}