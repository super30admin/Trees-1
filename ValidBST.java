// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
/** Iterative approach
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
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev =root;
            root=root.right;
        }
        return true;
        
    }
}
/* Recursion
class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {

        return helper(root);
        
    }
    
    private boolean helper(TreeNode root)
    {
        if(root==null) return true;
       
        if(helper(root.left)==false) return false;
        if(prev!=null) System.out.println(prev.val + "-->"+root.val);
        
        if(prev!=null &&  prev.val>=root.val)  return false;
        prev =root;
        
        return helper(root.right);
    }
}
*/