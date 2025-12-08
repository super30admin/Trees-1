
class Solution {
    private TreeNode prev;
    private boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        if(root==null) return false;
        helper(root);
        return flag;
    }
    //void based recursion (without conditions)
    private void helper(TreeNode root){
        //base
        if(root == null) return;

        //logic inorder
        //left
        helper(root.left);
        //root
        //breach condition
        if(prev!=null && prev.val >= root.val ){
            flag = false;
        }
        //System.out.println(root.val);
        prev = root;

        //right
        helper(root.right);

    }
    //void based conditional based recursion - based on certain condition only call the recursive calls only
    private void helper(TreeNode root){
        //base
        if(root == null) return;

        //logic inorder
        //left - condition
        if(flag) helper(root.left);
        //root
        //breach condition
        if(prev!=null && prev.val >= root.val ){
            flag = false;
        }
        //System.out.println(root.val);
        prev = root;

        //right condition
        if(flag)
        {helper(root.right);}

    }
}

//return type based recursion - boolean
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        return helper(root);
    }
    private boolean helper(TreeNode root){
        //base
        if(root == null) return true;
        //logic
        //left
        boolean left = helper(root.left);
        //inorder
        if(prev!=null && prev.val >= root.val){
            return false;
        }
        prev = root;
        //right
        boolean right = helper(root.right);
        return left && right;

    }

}