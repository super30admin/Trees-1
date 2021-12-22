// Time complexity - O(n)
// Space Complexity - O(h)
// Leetcode passed - Yes

public class isValidBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    boolean isValid = true;
    TreeNode prev = null;

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
    public boolean isValidBST(TreeNode root) {
        // We are using inorder traversal to compare the elements
        // Because inorder traversal of BST gives us sorted elements
        // So is the elements are sorted, that means its a BST
        // The moment it breaks the condition, that means it's not a BST
        inorderTraversal(root);
        return isValid;
    }

    public void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);

        // Comparing the prev value element with root node value in order to figure out if the elements are sorted
        if(prev!=null && prev.val>=root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorderTraversal(root.right);
    }
}
