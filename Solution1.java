// Time complexity: O(N), where N is the number of nodes in the tree.
// Space complexity: O(d), where d is the maximum depth of the tree. 

class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
  
    boolean result = true; 
    TreeNode prev = null;

    private boolean inorder(TreeNode root) {
        // base case
        if(root == null) return true; 
        boolean leftTree = inorder(root.left);
        // return false if the val is lesser than the prev val.
        if(prev != null && root.val <= prev.val) {
            return false; 
        } 
        prev = root; 
        boolean rightTree = inorder(root.right);
        return leftTree & rightTree; 
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return inorder(root);
    }
}