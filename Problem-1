/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time: O(n) traversing all nodes in the tree once
//Space: O(1) not creating any auxillary space and under the memory stack is used which stores max of height space internally
class Solution {
    public boolean isValidBST(TreeNode root) {
        //redundent as we are checking this condition in helper function too.
       // if(root==null) return true;
        return helper(root,null,null);
    }
    boolean helper(TreeNode root,Integer min, Integer max)
    {
        if(root==null) return true;
        if(max!=null && root.val>=max)
            return false;
        if(min!=null && root.val<=min) return false;
      return  helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}

//Time: O(n) : n are number of nodes in tree
//Space: O(h) : h is tree height
class Solution {
       public boolean isValidBST(TreeNode root) {
           //base case
       if(root==null) return true;
        //create stack
           Stack<TreeNode> st=new Stack<>();
           TreeNode prev=null;
           TreeNode curr=root;
           //loop until we pop element from stack and its empty 
           while(!st.isEmpty() || curr!=null)
           {
               //if data exist push into stack
               if(curr!=null)
               {
                   st.push(curr);
                   curr=curr.left;
               }
               //if found null at left side
               else
               {
                   //pop element and check its value
                   curr=st.pop();
                   if(prev!=null && curr.val<=prev.val)
                       return false; 
                   //reassign curr and check right side iff exist , if right is null then abv all conditions wont run and we wont be checking any curr or prev value against null entry so good to skip that
                   prev=curr;
                   curr= curr.right;
               }
           }
           return true;
       }
    
    }
