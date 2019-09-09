//Passed all the test cases on teh Leet Code
//Time Complexity : O(N)
//Space Complexity : O(N)
//Solved using recusrion and creating a helper function in which two values min and max are being passed .The minimum value that is being passed is
//Double.NEGATIVE_INFINITY and max value is Double.POSITIVE_INFINITY.


class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }

    boolean isBST(TreeNode node, double min, double max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.val <=min || node.val >= max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBST(node.left, min, node.val) &&
                isBST(node.right, node.val, max));
    }
}

//Not sure why this solution doesn't work here
/*class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left.val < root.val){
            return true;
        }
        if(root.right.val > root.val){
            return true;
        }
        if(isValidBST(root.left) && isValidBST(root.right)){
            return true;
        }

        return false;

    }
}*/
