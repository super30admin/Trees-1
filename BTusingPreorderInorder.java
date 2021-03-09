//Time Complexity: O(n) 
//Space Complexity:  O(n) asymptotically


//Code
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
        
        if(preorder == null || preorder.length == 0)
            return null;
        if(inorder == null || inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        
        //find root in inorder to separate LST and RST
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        //Preorder
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        //Inorder
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}           
    }
}