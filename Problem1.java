public class Problem1 {
//1st way to solve
// Time Complexity : O(n) -> traversal
// Space Complexity : O(h) -> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    //Here the approach is to go with any order traversal(DFS) and move till the left most and then start checking if prev values is greater than the roots value
    //as the property of BST the node to its left will always be smaller and node to right is always greater.
    boolean isValid = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        return isValid;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
        }
        prev = root;
        dfs(root.right);
    }


// 2nd way to solve

    //in this approach we're checking if the the value at current node is greater than or equal to left / right.
    // as we move down to the root.left the left value would be same and right max value would be right and viceversa for root.rigt.
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        dfs(root,null,null);
        return isValid;
    }
    private void dfs(TreeNode root, Integer left, Integer right){
        if(root == null){
            return;
        }

        dfs(root.left,left,root.val);
        dfs(root.right,root.val,right);
        if((left != null && left >= root.val) || (right != null && right <= root.val)){
            isValid = false;
        }
    }
}
