//TC : O(N) - Iterating on all nodes of tree
//SC : O(1)
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        
        inorder(root);
        return flag;
    }
    
    public boolean inorder(TreeNode root){
        if(root == null)    return false;
        
        inorder(root.left);        
        
        if(prev != null && root.val <= prev.val)    flag = false;
        prev = root;
        inorder(root.right);
        
        return true;
    }
}


//Using Min-Max values for each node in tree

/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }
    public boolean validBST(TreeNode root, Integer min, Integer max){
        
        if(root == null)    return true;
        
        if(min != null && root.val <= min)  return false;
            
        if(max != null && root.val >= max)  return false;
        
       
        boolean leftTree = validBST(root.left, min, root.val);
        boolean rightTree = validBST(root.right, root.val, max);
        
        return leftTree && rightTree;
    }
}

*/

