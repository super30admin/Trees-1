public class ValidateBinarySearchTree {
    public class TreeNode {
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
    //https://leetcode.com/problems/validate-binary-search-tree/description/
    boolean isValid = true;
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
        findValidity(root, null, null);
        return isValid;

    }

    private void findValidity(TreeNode root, Integer min, Integer max ){
        if(root==null){
            return;
        }

        findValidity(root.left, min, root.val);
        if ((min!=null &&root.val<=min) || (max!=null &&root.val>=max)){
            isValid = false;
            return;
        }
        findValidity(root.right, root.val, max);

    }






    //TreeNode prev;
    //boolean isValid;

    // Iterative Solution
    /** * public boolean isValidBST(TreeNode root){
     if(root == null){
     return true;
     }
     // Take previ pointer
     TreeNode prev = null;
     Stack<TreeNode> s = new Stack<>();

     while(root!=null || !s.isEmpty()){
     while(root !=null){
     s.push(root);
     root = root.left;
     }
     root = s.pop();
     if(prev!=null &&  prev.val>=root.val){
     return false;
     }
     prev =root;
     root = root.right;
     }
     return true;


     }**/


    /** public boolean isValidBST(TreeNode root) {
     if (root == null) {
     return true;
     }
     prev = null;
     isValid = true;
     inorder(root);
     return isValid;
     }

     private void inorder(TreeNode root) {
     if (root == null)
     return;
     inorder(root.left);
     if(prev!=null && prev.val >= root.val){
     isValid = false;
     return;
     }
     prev =root;
     inorder(root.right);

     }*/
}
