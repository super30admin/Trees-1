//Time complexity: O(h) 
//Space complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. Do inorder traversal of the tree
               2. Keep a track of the previous element
               3. Check if the previous element is smaller than the current element
*/
class validateBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return valid(root);
    }
    private boolean valid(TreeNode root){
        if(root == null) return true;
        if(!valid(root.left)) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        return valid(root.right);
    }
}
