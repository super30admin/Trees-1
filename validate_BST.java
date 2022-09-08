// Recursive

//TimeComplexity O(n)
//Spacecomplexity O(h) height if the tree

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    
    private void inorder(TreeNode root){
        if(root == null)return;
        
        //
        if(flag){
            inorder(root.left);
        }
        
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        
        if(flag){
            inorder(root.right);
        }
}
}

