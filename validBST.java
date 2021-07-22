//TC: O(n)
//SC: O(n)
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
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        // result = true;
        // helper(root, null, null);
        // return result;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null  || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
        
        // result = true;
        // inorder(root);
        // return result;
        
        //return inorder(root);
        
    }
    
    private void helper(TreeNode root, Integer min, Integer max) {
        //base
        if(root == null) return;
        
        helper(root.left, min, root.val);
        if((max!=null && root.val >= max) || (min!=null && root.val <= min)) {
            result = false;
            return;
        }
        helper(root.right, root.val, max);
    }
    
//     private void inorder(TreeNode root) {
//         //base case
//         if(root == null) return;
        
//         inorder(root.left);
//         //System.out.println(root.val);
//         if(prev!=null && prev.val >= root.val) {
//             result = false;
//             return;
//         }
//         prev = root;
//         inorder(root.right);
//     }
    
    private boolean inorder(TreeNode root) {
        //base case
        if(root == null) return true;
        
        if(inorder(root.left) == false) return false;
        //System.out.println(root.val);
        if(prev!=null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return inorder(root.right);
    }
}