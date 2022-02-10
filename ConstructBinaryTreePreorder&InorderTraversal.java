//TC: O(n*n) -- because we are calling helper function on inorder & preorder both the arrays and for both of them for loop is being used

//SC: O(n*n) -- because we are maintaing auxilary arrays on both sides of root i.e each of in/pre left and in/pre right

//Not optimal solution

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
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //null check
        if(preorder == null || preorder.length == 0) return null;
        
        //logic 
        int rootVal = preorder[0]; //first element is root node in preorder (Root--Left--Right)
        TreeNode root = new TreeNode(rootVal); //inserting root node in tree
        
        int rootIdx = -1;
        //searching root in inorder array
        for(int i = 0; i< inorder.length;i++){
            if(rootVal == inorder[i]){
                rootIdx = i;
                break; 
            }
        }
        
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        
        root.left =  buildTree(preorderLeft, inorderLeft);
        root.right =  buildTree(preorderRight, inorderRight);
        return root;

        
    }
}