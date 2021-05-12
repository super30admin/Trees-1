// Time : O(n), n=number of nodes in tree
// Space : O(h), h=height of tree
// did it run successfully on leetcode: yes
class ValidBst {
    //global variable to store previous node value
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {

        return helper(root);
    }
    // helper method to traverse the tree in-order
    public boolean helper(TreeNode root) {
        //if null its a valid tree
        if (root == null) return true;
        //left sub tree not valid
        if (helper(root.left) == false) return false;
        //previous node greater than current node
        if (prev != null && prev.val >= root.val) {
            return false;

        }
        //update previous to current node
        prev = root;
        //check right sub tree
        return helper(root.right);
    }

}