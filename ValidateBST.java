// Time Complexity : O(n) -> due to going through all nodes
// Space Complexity : O(n) -> worst case tree can be linear and no of stacks i.e. height of tree will be n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Use recurssion(i.e DFS). Each node must lie within a range (low < node.val < high). Find left and right ans for both subtrees. For the left subtree, the high boundary is updated to node.val. For the right subtree, the low boundary is updated to node.val. If at any time a node's value is not in the valid range, return false.


/**
 * Definition for a binary tree node.
 */
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

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            return __isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }

    //use boundaries
    private boolean __isValidBST(TreeNode root, long low, long high) {
        if(root == null) {  //base case
            return true;
        } else {
            if(root.val > low && root.val < high) { //root is within limit
                boolean leftAns = __isValidBST(root.left, low, new Long(root.val)); //find ans in left subtree
                boolean rightAns = __isValidBST(root.right, new Long(root.val), high);  //find ans in right subtree
                return leftAns && rightAns; //return and of both child tree answer
            } else {    //not within boundaries return false
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ValidateBST validator = new ValidateBST();

        // Example 1 (Valid BST)
        //     2
        //    / \
        //   1   3
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Is Valid BST? " + validator.isValidBST(root1));

        // Example 2 (Not a BST)
        //      5
        //     / \
        //    1   4
        //       / \
        //      3   6
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Is Valid BST? " + validator.isValidBST(root2));
    }
}
