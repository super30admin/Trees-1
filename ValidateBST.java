// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(N), to store the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        Stack<Integer> st = new Stack<>();
        TreeNode prev = null;

        while(root != null || !st.isEmpty()){
            while(root != null){ //inorder(root.left)
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}