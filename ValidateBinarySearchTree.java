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

class Solution {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
}

    // public boolean inorder(TreeNode root)
    // {
    //     //base
    //     if(root == null)  return true;

    //     if(inorder(root.left) == false) return false;
    //     //breach happens
    //     if(prev != null && prev.val >= root.val)
    //     {            
    //         return false;
    //     }
    //     prev = root;
 
    //     return  inorder(root.right);
    // }
    private boolean helper(TreeNode root, Integer min, Integer max)
    {
        //base
        if(root == null) return true;

        if(min != null && root.val <= min)
        {
            return false;
        }
        if(max !=null && root.val >= max)
        {
            return false;
        }

        return helper(root.left, min,root.val) && helper(root.right, root.val, max);
    }
}