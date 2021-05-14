/*
Desc: Here we have two solutions, one using void return in recursion and another using boolean
however the logic remains same, i.e; we move until the left most leaf node of the tree and move to
the root to right. If the consecutive nodes that are encountered are not greater htan the previous node
we declare the BST as invalid.( because in inorder traversal the nodes encountered are in a ascending order
on a valid BST )
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
     private boolean inorder(TreeNode root){
        if(root==null){
            return true;
        }
        if(inorder(root.left)==false) return false;
         if(prev!=null && prev.val>= root.val) return false;
         prev = root;
        return inorder(root.right);

    }
}

class Solution {
    boolean isValid = true;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
            isValid = false;      //we make the isValid variable false declaring BST as invalid and return.
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
