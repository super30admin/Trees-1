// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Lagging pointer solution

 // prev would point to the last element came out of stack 

 // and then prev would point to the inorder before going to the right
class Solution {
    TreeNode prev=null;
    boolean isvalid = true;
public boolean isValidBST(TreeNode node) {    

    checkBST(node);
    return isvalid;
}

private void checkBST(TreeNode root){

// null check
if(root == null){
return;
}

//get prev go left  
checkBST(root.left);
if(prev!= null && root.val <= prev.val){
isvalid= false;
return;
}
// prev = root go right
prev = root;

checkBST(root.right);


}
