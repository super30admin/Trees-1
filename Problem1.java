//Time complexity-O(n)
//Space complecxity-O(n)-stack
//Did the code run on leetcode- Yes 
//Aproach- pushing all the left elements from root to the stack and checking if the last element inserted is greater than next popped element , if true
        //the property fails else we continue and add the right element of the popped element to he stack.

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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
             return true;
        TreeNode prev=null;
        
        
        Stack<TreeNode> st= new Stack<>();
        
        while(!st.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            
            TreeNode curr= st.pop();
            
            if(prev!=null && prev.val>=curr.val)
                return false;
            
            prev=curr;
            root=curr.right;
            
        }
        return true;
    
        
    }
}