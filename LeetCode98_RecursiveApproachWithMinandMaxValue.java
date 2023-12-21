//following recusrive solution is independent of the traversal we do, 
//cause we are not comparing the pev bvalu with next value, which def require us to do in-order traversal!!
//but here we are checking min and max value of each node, that should fall into a certain range, if it's out of it we
//return false and min and max value of every node will remain same and independet of traversal we do. 
//Space -O(h) - height of the tree
//TC- O(n) - n = nodes of the tree

//approach -1 - just in-order traversal, part 1 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return checkValidity(root, null, null); //Integer.max and min value;
    }
    private boolean checkValidity(TreeNode root, Integer max, Integer min)
    {
        //base case
        if(root  == null) return true;

        //left treee
        boolean left = checkValidity(root.left, root.val, min);
        if(max != null && root.val >= max) return false;

        boolean right = checkValidity(root.right, max, root.val);
        if(min != null && root.val <= min) return false;

        return left && right;
    }
}

//approach-2 in-order traversal part2
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return checkValidity(root, null, null); //Integer.max and min value;
    }
    private boolean checkValidity(TreeNode root, Integer max, Integer min)
    {
        //base case
        if(root  == null) return true;

        //left treee
        
        if(max != null && root.val >= max) return false;

        boolean left = checkValidity(root.left, root.val, min);
        boolean right = checkValidity(root.right, max, root.val);
        
        if(min != null && root.val <= min) return false;

        return left && right;
    }
}

//approach-3 Pre-order traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return checkValidity(root, null, null); //Integer.max and min value;
    }
    private boolean checkValidity(TreeNode root, Integer max, Integer min)
    {
        //base case
        if(root  == null) return true;

        //left treee
        boolean left = checkValidity(root.left, root.val, min);
        boolean right = checkValidity(root.right, max, root.val);
        
        
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;

        return left && right;
    }
}

//approach -4, post order traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return checkValidity(root, null, null); //Integer.max and min value;
    }
    private boolean checkValidity(TreeNode root, Integer max, Integer min)
    {
        //base case
        if(root  == null) return true;

        //left treee
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;

        boolean left = checkValidity(root.left, root.val, min);
        boolean right = checkValidity(root.right, max, root.val);

        return left && right;
    }
}
