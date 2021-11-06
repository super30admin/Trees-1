// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
         
        return helper(preorder, 0, preorder.length - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end || p == preorder.length) {
            return null;
        }
        
        int inorderIndex = map.get(preorder[p]);
        TreeNode root = new TreeNode(preorder[p]);
        p++;
        root.left = helper(preorder, start, inorderIndex-1, map);
        root.right = helper(preorder, inorderIndex+1, end, map);
        
        return root;
    }
}
