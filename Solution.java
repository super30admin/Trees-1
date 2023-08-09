//Time Complexity - O(n)
//   Space Complexity - O(n)


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
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {

        inorder(root);
        //with boolean
        return flag;

    }
    public void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);//stk.push(parent)//abandon parent go to baby
        //stk.pop()
        //at the root node,chk for prev
        if(prev!=null && prev.val>=root.val)
        {
            flag=false;
            return;
        }
        prev=root; //set prev to root before moving to right subtree /side
        inorder(root.right);//stk.push->parent
        //stk.pop

    }
}