
class Solution {
    int past;
    boolean flag=false;
    public boolean isValidBST(TreeNode root) {
        past=Integer.MIN_VALUE;

        return helper(root);


    }

    private boolean helper(TreeNode node){

        if(node==null){
            return true;
        }

        boolean left = helper(node.left);
        if(flag==true && past>=node.val){
            return false;
        }
        past=node.val;
        flag=true;
        boolean right =  helper(node.right);
        return left&&right;


    }

}