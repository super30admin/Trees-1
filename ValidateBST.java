public class ValidateBST {
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
  //TC : O(N)
    // SC: O(H) where H is height of the tree
    //Leetcode : 98
    TreeNode prev;
    boolean flag;
    //recursive
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inOrder(root);
        return flag;
    }
    private void inOrder(TreeNode root) {
        //base
        if(root == null) return;
        if(flag)
            inOrder(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        if(flag)
            inOrder(root.right);
    }

    //Iterative solution
    /*public boolean isValidBSTIterative(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root !=null && !st.isEmpty())  {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }*/

}
