time complexity: O(n)
space complexity: O(h), h - height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    //to have the range of each node element 
}
 
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) //base condition initial check
        return true;
 
    if(p.val <= min || p.val >= max) //node value shouldn't be less than min or greater than max
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max); //doing recursive on both left and right
}
    }