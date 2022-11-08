// Approach : DFS
// Time Complexity : O(n) where n is the size of the tree. Wrost case when the tree is BST we have to go through all the nodes and validate each node.
// Space Complexity : O(n) , worst case when the tree is fully skewed to process it fully we will use n stack space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsValidBST(TreeNode root) {
        return IsValidBST(root, null, null);
    }
    
    public bool IsValidBST(TreeNode node, int? low, int? high){
        if(node == null) return true;
        
        if((low != null && node.val<= low) || (high!=null && node.val >= high))
            return false;
        
        if(!IsValidBST(node.left, low, node.val)) return false;
        
        return IsValidBST(node.right, node.val, high);
    }
}