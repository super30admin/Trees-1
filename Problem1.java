// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//To find the valid BST, by keeping the track of prev root and check if that root is always
//less than the next visiting root in inorder traversal.

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Problem1 {
    TreeNode[] prev = new TreeNode[1];

    public boolean isValidBST(TreeNode root) {
        prev[0] = null;
        return helper(root, prev);
    }

    public boolean helper(TreeNode root, TreeNode[] prev) {
        if (root == null) return true;
        boolean left = helper(root.left, prev);
        if (prev[0] != null && prev[0].val >= root.val) {
            return false;
        }
        prev[0] = root;
        boolean right = helper(root.right, prev);
        return left && right;
    }

    public static void main(String[] args) {
       
        Problem1 solution = new Problem1();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

       
        boolean result = solution.isValidBST(root);

        
        System.out.println("Is the binary tree a valid BST? " + result);
    }
}
