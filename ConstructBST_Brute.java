// Time Complexity : O(n^2) --> where n is length of input (preorder / inorder) array
// Space Complexity : O(2^n) --> 
// Did this code successfully run on Leetcode (105): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if (preorder.length == 0 || inorder.length == 0) return null;

        // logic
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) index = i;
        }
        
        int preLeft[] = Arrays.copyOfRange(preorder, 1, index + 1);
        int preRight[] = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int inLeft[] = Arrays.copyOfRange(inorder, 0, index);
        int inRight[] = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}