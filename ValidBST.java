/*
Time Complexity : O(N) where N is the number of nodes in the tree
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach: We can do an inorder traversal of the tree and check 
if the values are in increasing order. If we find any value that
is not greater than the previous value, then it is not a valid BST. 
Basically we have a flag to check for any breaches.
*/

class ValidBST {
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;

        if (flag) {
            helper(root.right);
        }
    }

    public static void main(String[] args) {
        ValidBST solution = new ValidBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root)); // Output: true
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}