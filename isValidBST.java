//Time complexity: O(N); n - number of nodes
//Space complexity: O(H), H - height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
         return isValidBST(root, null, null); // can be written this way as well ->
        //return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
        //to have the range of each node element 
}
 
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) //base condition initial check
        return true;
   //logic
    if(p.val <= min || p.val >= max) //node value shouldn't be less than min or greater than max
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max); //doing recursive on both left and right
}
    }