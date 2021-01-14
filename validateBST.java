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
        if(root == null) return true;
        return inorder(root);
        /*
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root!= null){
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(prev!= null && prev.val >= root.val) return false;
            prev = root;
            root =  root.right;
        }
        return true;
        */
    }    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
         if(inorder(root.left) == false) return false;
            if(prev!= null && prev.val >= root.val) return false;
            prev = root;
            return inorder(root.right);
    }
}
//Time Complexity: O(n) in the worst case
//Space Complexity: O(h) to keep the run time stack where h is the height of the tree
