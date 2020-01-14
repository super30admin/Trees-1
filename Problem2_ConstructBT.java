/************ Time Complexity: O(n) ************/
/************ Space Complexity: O(n) ************/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length==0)
            return null;
        
        // considering 1st element of preorder to be root
        TreeNode root = new TreeNode(preorder[0]);
        //initialization
        int index = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val){
                //root = i index
                index = i;
            }
        }
        
        // inorder_left = 0 -> index
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        // inorder_right = index+1 -> inorder.length
        int[] inorder_right= Arrays.copyOfRange(inorder, index+1, inorder.length);
        // preorder_left = 1 -> index+1
        int[] preorder_left= Arrays.copyOfRange(preorder, 1, index+1);
        // preorder_right = index+1 -> preorder.length
        int[] preorder_right= Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        root.left = buildTree(preorder_left, inorder_left);
        root.right = buildTree(preorder_right, inorder_right);
    
        return root;
    }
}