// S30 Big N Problem #44 {Medium}
// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
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
        if(preorder.length==null || inorder.length==0) return null;
        int index=-1;
        TreeNode root=new TreeNode(preorder[0]);
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                index=i;
                break;
            }
        }
        
        int [] inLeft=Arrays.copyOfRange(inorder,0,index);
        int [] inRight=Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        int [] preLeft=Arrays.copyOfRange(preorder,1,index+1);
        int [] preRight=Arrays.copyOfRange(preorder,index+1,preorder.length);
        
        root.right=buildTree(preRight,inRight);
        root.left=buildTree(preLeft,inLeft);
        
        return root;
    }
}