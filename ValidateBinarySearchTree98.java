/* Time Complexity : O(n)
 Space Complexity : O(h)
   where h : height of tree.
 Did this code successfully run on Leetcode : yes

Three line explanation of solution in plain english:
 
  Perform inorder traversal. Maintain previous pointer, while traversing a tree check if the current node value is less than the previous node value.
  If not return false. Else return true.  
 */
class Solution {
    boolean isValid = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) { 
        if(root == null){
            return isValid;
        }
        inorder(root);
        return isValid;
       
    }
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            isValid =false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
