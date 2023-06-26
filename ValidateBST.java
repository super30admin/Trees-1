class ValidateBST {
  boolean flag;
  public boolean isValidBST(TreeNode root) {
      this.flag=true;
      helper(root,null,null);
      return flag;
  }
  
  private void helper(TreeNode root, Integer low, Integer high){
      if(root==null)
          return;
      if((low!=null && low>= root.val) || (high!=null && high<= root.val)){
          flag=false;
          return;
      }
      helper(root.left,low,root.val);
      helper(root.right,root.val,high);
  }
}
