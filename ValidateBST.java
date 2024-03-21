// TC: O(n) // where n is the number of nodes.
// SC: O(h) // where h is the height of the tree, since the space is used by recursion and at any time the maximum nodes present in the call stack is equal to the height of the tree.
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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        flag = false;
        inorder(root);
        return !flag;
    }

    void inorder(TreeNode root) {
        if(root == null || flag) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = true;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}