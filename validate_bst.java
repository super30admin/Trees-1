// time complexity = 0(n) n- number of nodes in the tree
// space complexity = o(h) h - height of the tree
// we use condition recursion, it checks if the left is smaller to the root value, if yes then only moves and checks for right value, cutting the time down as soon as we encounter an issue. 

class Solution {
    TreeNode prev;
    // boolean flag;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    private boolean helper(TreeNode root){
        // base case
        if (root == null) return true;

        // left
        boolean left = helper(root.left);
        if(prev!=null && root.val<=prev.val){
            return false;
        }
        this.prev = root;
        // right
        boolean right = true;
        if(left){
            right =helper(root.right); //conditional recursion 
        }
        return left && right;

    }
}