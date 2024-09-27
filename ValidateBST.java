
// Time Complexity : O(n) 
// Space Complexity : O(1) if Recursion Stack is not considered or else O(H) H = height of BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1.BST is a Binary tree in whih every Node in a Binary Tree has it's left node less than or equal to it's parent node.
//2. The right node in the BST is greater than or equal to the parent node.


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
}

class Solution {
    public boolean isValidBST(TreeNode root) {

        return validateBST(root, null, null);
    }

    public boolean validateBST(TreeNode node, Integer low, Integer high) {

        if (node == null)
            return true;

        if ((low != null && node.val <= low) || (high != null && node.val >= high))
            return false;

        return validateBST(node.left, low, node.val) && validateBST(node.right, node.val, high);

    }

    public static void main(String args[]) {
        Solution obj = new Solution();

        TreeNode l = new TreeNode(100);
        TreeNode r = new TreeNode(23);
        TreeNode newTree = new TreeNode(20, l, r);
        System.out.println(obj.isValidBST(newTree));

    }
}