 //Validate a BSt
 // Time Complexity : O(n) n - number of nodes
// Space Complexity :O(h) h - height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
recursion approach 
use two global variables treenode and boolean to return true/false
we travel in inorder fashion, first traverse root.left till we reach leaf
once we reach leaf, we return. 
when we return we check if prev val > root val and return false
else 
we make root node as prev node and traverse right of the root

*/


// Your code here along with comments explaining your approach
 class Problem1{
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));

    }
    public static TreeNode prev;
    public static boolean isBST;
    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        prev = null;
        isBST = true;
        helper(root);
        return isBST;

    }
    public static void helper(TreeNode root){
        if(root == null)
            return;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            isBST = false;
        }
        prev = root;
        helper(root.right);

    }
}