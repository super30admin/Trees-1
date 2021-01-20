// Recursive function - checking if at any current node whether it is greater than left child and less than right child
// TC: O(N)
// SC: O(H) -> height of the tree (in case of complete BST H = lg(n))
class Solution {
    public boolean isValidBST(TreeNode root) {
         return helper(root, null, null);
     }
      private boolean helper(TreeNode root, Integer min, Integer max)
      {
            // if root is null, then it is automatically a BST
          if (root == null)
             return true;
             // if anytime root is less than left node value, then it is not BST
          if (min!= null && root.val <= min )
              return false;
              // if anytime root is greater than right node value, then it is not BST
          if (max!= null && root.val >= max )
              return false;
 
          return helper(root.left, min, root.val) && helper(root.right, root.val, max);
      }
   }