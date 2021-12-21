public class ValidBST {
    public class TreeNode {
        int val;
        ValidBST.TreeNode left;
        ValidBST.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
    /*
    TC: O(n)
    SC: O(n)
    */
        if(root==null) return true;
        return helper(root,null,null);
    }

    private boolean helper(TreeNode root,Integer left,Integer right)
    {
        if(root==null) return true;

        if((left!=null && root.val<=left) || (right!=null && root.val>=right)){
            return false;
        }

        return helper(root.left,left,root.val) && helper(root.right,root.val,right);
    }
}
