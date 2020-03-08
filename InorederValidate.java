/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//o(n) time and o(n) space
//passed all leetcode cases
//used approach discussed in class
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null|| !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(prev !=null && root.val<=prev.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }

}