// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int pre_idx = 0;
    int[] inorder;
    int[] preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        int idx = 0;
        for(Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
    
    public TreeNode helper(int in_left, int in_right) {
        if(in_left > in_right)
            return null;
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(in_left, index - 1);
        root.right = helper(index + 1, in_right);
        return root;
    }
}