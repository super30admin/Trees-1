//Time complexity : O(n)
//Space complexity : O(h)

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
class ValidateBST {
    // Boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //isValid = true;
        return checkValidity(root, null, null);
        //return isValid;
    }
    public boolean checkValidity(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        boolean case1 = checkValidity(root.left, min, root.val);
        if((min != null && root.val <= min) || (max  != null && root.val >= max)){
            return false;
        }
        boolean case2 = checkValidity(root.right, root.val, max);
        return case1 && case2;
    }

}