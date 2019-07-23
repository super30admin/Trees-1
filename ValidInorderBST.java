//Using inorder property where sorted output array is validBST . For inorder we traverse from root to left most node, 
//we pop it and go to its right node(and go to its left and so on!!).
//Time Complexity: O(n)
//Space Complexity:O(n) stack space

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root ==null)
            return true;
        
        TreeNode prev = null;
        
        Stack<TreeNode> stack = new Stack();
        
        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
            stack.push(root);
            root= root.left; //always take all the left!!
            }
            
            root=stack.pop();
            
            if(prev!=null && root.val <= prev.val) return false; //inorder is always sorted
            prev = root; 
            root=root.right;
            
        }
        
        return true;
    }
}
