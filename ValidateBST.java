// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We traverse the tree in inorder and try to find if the prev element is greater than or equal to current element. If yes, the inorder is not sorted and its not a valide BST. In Alternate methode we use range of eeach node with the parent nodes values. 

class Solution {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root){

        if(root == null) return true; 

        boolean left = helper(root.left);
        if(prev!=null && root.val <= prev.val) return false;
        prev = root;
        System.out.println(root.val);
        boolean right = true;
        if(left){
            right = helper(root.right);
        }
        
        return left && right;
    }

    // public boolean isValidBST(TreeNode root) {
    //     return helper(root, null, null);
    // }

    // Using range of each node
    private boolean helper2(TreeNode root, Integer min, Integer max){
        
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max !=null && root.val >= max) return false;

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }
}