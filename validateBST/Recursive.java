package validateBST;

//Time Complexity: O(n), where n is the number of nodes in the tree (since each node is visited once).
//Space Complexity: O(h), where h is the height of the tree. In the worst case (unbalanced tree), this is O(n), and in the best case (balanced tree), it is O(log n).

/**
 * Definition for a binary tree node.
 * public class validateBST.TreeNode {
 *     int val;
 *     validateBST.TreeNode left;
 *     validateBST.TreeNode right;
 *     validateBST.TreeNode() {}
 *     validateBST.TreeNode(int val) { this.val = val; }
 *     validateBST.TreeNode(int val, validateBST.TreeNode left, validateBST.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class ValidateBST {
    private boolean flag;
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        inorder(root);
        return flag;
    }

    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            flag = false;
        }
        prev=root;
        inorder(root.right);
    }
}