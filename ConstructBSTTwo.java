// Time Complexity : O(n) --> where n is length of input (preorder / inorder) array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (105): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Integer, Integer> map;
    int index; // index of roots in preorder
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // edge case
        if (preorder.length == 0 || inorder.length == 0) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        // base case
        if (start > end || index >= preorder.length) return null;
        
        // logic
        int inIdx = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, inorder, start, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, end);
        return root;
    }
}