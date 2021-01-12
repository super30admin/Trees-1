// Time Complexity : O(n) n:number of nodes
// Space Complexity : O(h) h:height of tree
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

//pre-order
//validate root then validate left and right, if anything is invalid then everything is invalid.
public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    return isValid(Long.MIN_VALUE, Long.MAX_VALUE, root);
}

public static boolean isValid(long min, long max,TreeNode node){
    if(node == null) return true;
    if(node.val <= min || node.val >= max) return false;
    return isValid(min, node.val, node.left) && isValid(node.val, max, node.right);
}

//In-order should be shorted
TreeNode pre; 
public boolean isValidBST(TreeNode root) {
    return isValid(root);
}

public boolean isValid(TreeNode node){
    boolean valid = true;
    if(node == null) return true;
    valid &= isValid(node.left);
    if(pre != null && node.val <= pre.val) return false;
    pre = node;
    valid &= isValid(node.right);
    return valid;
}