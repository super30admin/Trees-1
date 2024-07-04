public class ValidateBinaryTree {
}

/**
    Approach: inorder traversal L Root R

        Working:
        Declare prev -> TreeNode
        Declare isValid -> true;

        inorder(root)
            //base case

            //recurse
            traverse to left inorder(root.left)

            //logic
            check if the previous node valu is greater than the  current node value
                set isValid = false
                return;

            set prev = root
            //recurse
            traverse to right tree inorder(root.right)



        Time Complexity: O(n)
        Space Complexity: O(h) - recursive stack space, max entries present in the stack a a point

*/

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
class Solution {
    TreeNode prev;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {

        if( root == null) {
            return false;
        }
        inorder(root);
        return isValid;

    }

    private void inorder(TreeNode root) {


        if(root == null) {
            return;
        }

        inorder(root.left);

        if(prev != null && prev.val >= root.val) {

            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);

    }
}
