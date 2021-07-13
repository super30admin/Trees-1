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
        if(root==null) return true;
        Stack<TreeNode> st=new Stack<>();
        TreeNode prev=null;
        while(true)
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            if(st.isEmpty())
                break;
            root=st.pop();
            if(prev!=null && root.val<=prev.val)
            {
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true; 
    }
}

// Time Complexity: O(n), where n is no of nodes in tree.

// Space Complexity: O(h), where h is height of tree.