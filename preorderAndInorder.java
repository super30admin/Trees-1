// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Its a bit complicated to implement, remember the base case of helper function


// Your code here along with comments explaining your approach
class Solution {
    // Global variables
    Map<Integer, Integer> map = new HashMap<>();
    int idx;    // idx will keep track of the element in the inorder array

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }

        // Populate map with inorder array <value, index>
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //  Call the helper function which will construct the tree from preorder and return the root
        return helper(preorder, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if (start > end) {
            return null;
        }

        //logic
        TreeNode root = new TreeNode(preorder[idx]);    // Create a node with the value as preorder[idx]
        int rootIdx = map.get(preorder[idx]);           // get the value of the index where preorder[idx] value lies in the inorder array, this index will be useful in the left and right recurse
        idx++;                                          // increment the idx for the next value in preorder

        // Recurse
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);

        // Return
        return root;
    }
}