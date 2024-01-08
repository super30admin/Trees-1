/*
* Approach:
*  1. At every node, the value must be checked with min and max.
* 
*  2. root will have min and max as null.
        for left subtree,
            min => same as root's min
            max => value of root
        
        for right subtree,
            min => value of root
            max => same as root's max
* 
*  3. if value of node is >= min or <=max,
        then its not a BST.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    exploring all the nodes.
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

public class ValidateBST {
    private boolean flag = true;

    private void helper(TreeNode root, Integer max, Integer min) {
        if (root == null)
            return;

        if ((max != null && root.val >= max) ||
                (min != null && root.val <= min)) {
            flag = false;
            return;
        }

        // left subtree
        helper(root.left, root.val, min);

        // right subtree
        helper(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        helper(root, null, null);

        return flag;
    }
}
