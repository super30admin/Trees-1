// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes

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
    TreeNode previous;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        if(root == null) return;

        if(flag){
            helper(root.left);
        }
        if(previous!=null && previous.val>=root.val){
            flag = false;
        }
        previous = root;
        if(flag){
            helper(root.right);
        }
    }
}



// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
//Range-based approach
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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root,null,null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max){
        if(root == null) return;

        if(flag){
            helper(root.left, min, root.val);
        }
        if(min!=null && root.val<=min){
            flag = false;
        }
        if(max!=null && root.val>=max){
            flag = false;
        }
        if(flag){
            helper(root.right,root.val,max);
        }
    }
}