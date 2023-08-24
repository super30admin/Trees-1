//TC = O(n)
//SC = O(n)
//--Here we are using prev pointer to store the prev root so that we can compare with root
//--and it should always be less than root
class BinarySearch{
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        //base
        if(root == null) return;
        //logic
        helper(root.left);
        System.out.println(root.val);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        helper(root.right);

    }
}