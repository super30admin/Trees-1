// Time Complexity : O (n) 
// Space Complexity : O (1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : minor issues

public class prob1 {

    public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    boolean result;
    TreeNode prev;
    
    public boolean validBst(TreeNode root){
        if(root == null) return false;
        result = true;
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            result = false;
            return;
        }
        prev = root;
        helper(root.right);
    }

    public static void main(String[] args) {
        
    }
    
}
