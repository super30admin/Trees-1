// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        // Intialize stack
        Stack<TreeNode> st = new Stack<>();

        // Intialize previous pointer to compare value with
        TreeNode prev = null;
        
        // Iterate through the tree
        while(root != null || !st.isEmpty()){        
            
            // keep pushing the left children nodes
            // keep updating the root until we hit null value
            while(root != null){
                st.push(root);
                root = root.left;
            }

            // once we hit the null value on the left side,
            // pop the element from the stack

            root = st.pop();
        
            // check if the previously popped root is smaller than the current root
            if(prev != null && prev.val >= root.val){
                return false;
            }
            
            // update previous pointer
            prev  = root;

            // do the same for children nodes on right
            root = root.right;  
        }
        
        return true;
    }
}