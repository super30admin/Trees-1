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


//Aproach 1
//inorder using recursive stack and comparing values
//Time Complexity: O(N)
//Space complexity: O(N)

class Solution {
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        result = true;
        inorder(root);
        return result;
       
    }
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            result = false;
            return;
        }
        prev = root;
        inorder(root.right);
        
    }
}


//Approach 2
//Set a range for each node and check if it is present in that range for each node to be a BST
//Time Complexity: O(N)
//Space Complexity: O(height)
class Solution {
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result = true;
        if(root == null)
            return true;
        helper(root,null,null);
        return result;
    }
    public void helper(TreeNode root,Integer min,Integer max){
        if(root == null)
            return;
        //left subtree
        helper(root.left,min,root.val);
        //root
        //do null checks beofre comparision
        if((min!=null && root.val<=min) || (max!=null && root.val>=max)){
            result = false;
            return;
        } 
        //rightsubtree
        helper(root.right,root.val,max);
    }
}

