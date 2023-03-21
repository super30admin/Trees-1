// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We maintain a treenode prev and compare it with current node. If the prev value is greater then root, we set flag as false as it violates binary tree rules. 
 * We check inorder and compare the flag. 
 * We return when we reach null values.  
 */

class Problem1{
    boolean flag; 
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true; 
        Inorder(root);
        return flag;
    }
    private void Inorder(TreeNode root){
        
        if(flag == false) return; 
        if(root == null) return; 
        if(flag){
            Inorder(root.left);
        }
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        if(flag){
            Inorder(root.right);
        }
    }
}


