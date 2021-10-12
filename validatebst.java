// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
public boolean isValidBST(TreeNode root) {
    return checkBST(root, null, null);
}
public boolean checkBST(TreeNode node, Integer left, Integer right){
    if(node == null) return true; //an empty tree is a binary search tree
    //all the nodes in the left subtree needs to have values less than the root node value
    if(left != null && node.val <= left) return false;
    //all the nodes in the right subtree needs to have values greater than the root node value
    if(right != null && node.val >= right) return false;
    
    return checkBST(node.left, left, node.val) && checkBST(node.right,node.val,right);
}