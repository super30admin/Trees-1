/**
 *  Time Complexity: O(n)
 * Space Complexity: O(n)
 */
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
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    
    HashMap<Integer,Integer> index_map = new HashMap<Integer,Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        this.preorder = preorder;
        this.inorder = inorder;
        
        //creating a HashMap
        int idx = 0;
        for(Integer val : inorder)
        {
            index_map.put(val,idx++);
        }
        return helper(0,inorder.length-1);
    }
    
    public TreeNode helper (int left, int right)
    {
        if(left>right)
            return null;
        
        int root_val = preorder[pre_idx];
        
        //Find the root val in inorder
        TreeNode root = new TreeNode(root_val);
        pre_idx++;
        
        int index = index_map.get(root_val);
        
        //create left subtree
        root.left = helper(left,index-1);
        root.right = helper(index+1,right);
        return root;
    }      

}