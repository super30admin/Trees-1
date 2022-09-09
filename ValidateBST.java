class Solution {
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return true;
        
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        System.out.print("up");
        System.out.println(root.val);
        
        inorder(root.right);
        System.out.print("down");
        System.out.println(root.val);
    }
}