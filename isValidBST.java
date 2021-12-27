// Time Complexity :O(n)// n is no. of nodes in the tree
// Space Complexity : o(h) //h is the height of the Tree
// Did this code successfully run on Leetcode 98: yes
/*Approach: we are implementing inorder tree traversal (ascending order is obtained) and checking if the previous
element is less than the current element  */


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
    boolean isValid=true;
    TreeNode prev;
    Stack<TreeNode> st=new Stack<>();
    public boolean isValidBST(TreeNode root) {
      if(root==null)
          return false;
        helper(root);

        return isValid;
    }
    private void helper(TreeNode root){
        if(root==null)
            return;
        while(root!=null||!st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!=null && prev.val>=root.val){
            isValid=false;
            return;
        }
        prev=root;
            root=root.right;
        }
}
}
