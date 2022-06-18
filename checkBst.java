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
   //recursive call for left subtree(from left to root) and right subtree (root to right)and compare both
   //tc:O(n) sc: O(height)
   
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
    public boolean checkBST(TreeNode root, TreeNode left, TreeNode right){
        if(root == null){
            return true;
        }
        if((left != null && root.val <= left.val) || (right!= null && root.val >= right.val)){
            return false;
        }
        return checkBST(root.left, left, root) && checkBST(root.right, root, right);
    }
}


//iterative  from root, goto  extreme left by pushing inot stack, then pop from stack and compare with prev(if prev is null , popped element is prev)
class Solution {
   
   //TC: O(n) sc:O(h)
    public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> st=new Stack<>();
        TreeNode prev=null;
        
        while(root!=null||!st.isEmpty() ){
            //go to extreme left
            while(root!=null){
            st.push(root);
            root=root.left;  
            }
            
            root=st.pop();
            
            if(prev!=null && prev.val>=root.val)return false;
            
            prev=root;
            root=root.right;
        
            
        }
        return true;
        
    }
}
