// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(h) --> where h is height of tree (log n to n)
// Did this code successfully run on Leetcode (98): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            // System.out.println(curr.val + " " + prev.val);
            if (prev != null && prev.val >= curr.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}