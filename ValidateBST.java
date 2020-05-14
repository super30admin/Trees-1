
// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

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
        return helper(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long min, long max){
        if(root==null)
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean left = isValidBST(root.left);
        if(prev!=null && prev.val>=root.val)
            return false;
        prev=root;
        return left && isValidBST(root.right);
    }
}

// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        long prev=Long.MIN_VALUE;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            TreeNode tmpNode = st.pop();
            if(prev>=tmpNode.val)
                return false;
            prev=tmpNode.val;
            root=tmpNode.right;
        }
        return true;
    }
    
    
}

