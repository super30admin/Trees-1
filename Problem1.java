//Accepted on LT
//The idea here is to check the in  order and check if it in ascending order
//time should be O(n) as we are going on each and every node

class Solution {
    TreeNode prev;
    boolean b = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return b;
        
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        System.out.println(root.val);
        if(prev !=null && prev.val>=root.val){
            b = false;
        }
        prev = root;
        if(b) helper(root.right);

        return ;
    }
}