// Time Complexity : O(n)
// Space Complexity : O(h), Recursion stack O(h) where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Inorder traversal of a BST results in a sorted order of elements.
// using same intution, check curr > prev for a valid BST

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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.prev = null;
        flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root){
        //base
        if(root == null || !flag){
            return;
        }

        inorder(root.left);

        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root; // move prev to root.
        inorder(root.right);
    }
}


//Different Approach:
// Time Complexity : O(n)
// Space Complexity : O(h), Recursion stack O(h) where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keep range at each level based on the predecessors root 
//and check if root lies within the range of min and max

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
        return helper(root, null,null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null){ 
            return true; // did not find any breach yet
        }
        
        // breach condition: root should lie between min and max
        if((min != null && root.val <= min) || (max != null &&root.val >= max)){
            return false; 
        }

        //logic
        
        
        // Left subtree: keep min same and max = root
        // Right Subtree: keep max same and min == root
        //conditional based recursion: don't go to right subtree if breach is found in left
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}