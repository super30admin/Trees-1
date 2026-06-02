//Time Complexity: O(n)
//Space Complexity: O(h)
// Definition for a binary tree node.
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


public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return compareNode(root, null, null);
    }

    private boolean compareNode (TreeNode node, TreeNode lower, TreeNode upper) {
        if(node == null) return true;
        if(lower!= null && node.val<= lower.val) return false;
        if(upper != null && node.val >= upper.val) return false;
        return compareNode(node.left,lower,node) && compareNode(node.right,node,upper);

    }
}
