/*
* Approach:
*  1. Inorder traversal of BST will be in sorted order.
        To check this, 
            we apply inorder traversal and store values in a list.
            Then, we compare prev element with curr element.
* 
*  2. Same check can be inserted without the use of list during traversal.
*       Maintain a global treenode pointer,
             which holds the prev node reference.
*  3. Whenever we print root.val, compare it with prev pointer value.
        if it root.val < prev.val, not a BST
        
        everytime, update the prev pointer with root.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    exploring all nodes
* 
* Space Complexity: O(1)
* 
*/

class TreeNode {
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
};

public class ValidateBSTInorder {
    TreeNode prev = null;

    boolean flag = true;

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && prev.val >= root.val)
            flag = false;

        prev = root;

        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);

        return flag;
    }
}