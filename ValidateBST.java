
 //Definition for a binary tree node.
  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
   }


class ValidateBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        if(root==null)
            return true;

        if(inOrder(root.left)==false)
            return false;
        if(prev!=null && prev.val >= root.val){
            return false;
        }
        prev = root;
        return inOrder(root.right);
    }
    public static void main(String [] args){
        ValidateBST b = new ValidateBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.print(b.isValidBST(root));
    }
}