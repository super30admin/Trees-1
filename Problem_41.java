/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Time Complexity : O(N^2)
Space Complexity : O(N)

The idea is to pick first node as root in preorder traversal and the locate the element in inorder to identify left sub tree and right subtree till we traverse  all elements

**/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Boundary Class
        if(preorder == null || preorder.length < 1)
            return null;
        
        //Find root node 
        TreeNode node  = new TreeNode(preorder[0]);
        int curr_index = -1; 
        
        for(int i = 0; i < inorder.length; i++){
            if(node.val == inorder[i]){
                curr_index   =  i;
                break;
            }
            
        
        }
        
            //leftOrder Inorder Sub Tree
            int[] leftInorderTree   = Arrays.copyOfRange(inorder,0,curr_index);
            
             //rightOrder Inorder Sub Tree
            int[] rightInorderTree  = Arrays.copyOfRange(inorder, curr_index + 1, inorder.length);
        
            //leftOrder PreOrder Sub Tree
            int[] leftPreorderTree  = Arrays.copyOfRange(preorder,1,curr_index + 1);
            
            //rightOrder PreOrder Sub Tree
            int[] rightPreorderTree = Arrays.copyOfRange(preorder,curr_index + 1, preorder.length);
        
            //Build Subtree
            node.left  = buildTree(leftPreorderTree,leftInorderTree);
            node.right = buildTree(rightPreorderTree,rightInorderTree);
            
            return node;
    }
}
