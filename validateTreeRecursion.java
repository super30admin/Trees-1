/**
Running Time Complexity: O(n)
Space Complexity: O(n)
Sucessfully Run and Compiled on leetcode
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
        if(root==null) return false;
        prev = null;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        //base case
        if(root==null) return true;       
        //logic
        if(inorder(root.left)==false) return false;
        if(prev!=null && prev.val>=root.val) return false;
        prev = root;
        return inorder(root.right);
    }
}
//Stack solution:
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
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev = root; 
            root = root.right;
        }
    return true;
    }
}