// Time Complexity :O(N)*O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: By using recurression

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
class Solution {
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
       
        int idx = 0;
        for(Integer val: inorder){
            hmap.put(val,idx++);
        }
        return bstNode(0, inorder.length-1);
    }
    
    public TreeNode bstNode(int left, int right){
        if(left > right)
            return null;
        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);
        pre_index++;
        
        int idx = hmap.get(root_val);
        root.left = bstNode(left,idx-1);
        root.right = bstNode(idx+1, right);
        return root;
    }
}
