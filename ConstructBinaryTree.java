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
        // null case
        
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx=-1;
        //finding root in order
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                idx=i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0, idx); //idx=-1
        int[] preLeft =Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int[] inRight= Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] preRight= Arrays.copyOfRange(preorder, inLeft.length +1, preorder.length);
        
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
            
        return root;
        
    }
}