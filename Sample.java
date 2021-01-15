Problem11 (https://leetcode.com/problems/validate-binary-search-tree/)
Iterative: 
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes 
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
        if(root==null) return true;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                System.out.println(root.val);
                root=root.left;
            }
        root=st.pop();
        if(prev!=null && prev.val >= root.val) return false;
        prev=root;
        root=root.right;
        }
    return true;
    }
}
Optimal using Recursion
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root==null) return true;
        if(inorder(root.left)==false) return true;
        if(prev!=null && prev.val>=root.val) return false;
        prev=root;
        return inorder(root.right);
    }
}
