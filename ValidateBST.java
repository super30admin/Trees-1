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
      TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev= null;
        return  validate(root);
    }
    public boolean validate(TreeNode root){
        if(root== null) return true;
        boolean left= validate(root.left); 
        if(prev!= null && prev.val>=root.val) return false;
        prev= root;
        boolean right= validate(root.right);
        
        return left && right;
    }
}

//Iterative Solution

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev= null;
        Stack<TreeNode> st= new Stack<>();
        while(root!= null || !st.isEmpty()){
            while(root!= null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            
            if(prev!= null && prev.val>= root.val) return false;
            prev=root;
         
            root= root.right;
            
        }
        return true;
    }
}

// Time complexity- O(n)
//Space complexity- o(h) where h is the height of the tree