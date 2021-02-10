// Time Complexity :O(n)
// Space Complexity :O(n+depth of tree)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we are keeping hashmap of inorder elements and their indexes.we are starting from end of the postorder array 
// last index of the postorder would be the root and as an when we are traversing the postorder array from left to right 
//  we are finding its left and right in the inorder array and then recursively calling for right and left branch
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
    Map<Integer,Integer> hashmap;
    int preindex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hashmap = new HashMap<>();
        preindex = 0;
        
        for(int i = 0;i<inorder.length;i++){
            hashmap.put(inorder[i],i);
        }
        
        return buildNewTree(preorder,inorder,0,preorder.length-1);
    }
    
    private TreeNode buildNewTree(int[] preorder,int[] inorder,int instart,int inend){
        if(instart>inend){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preindex]);
        preindex++;
        
        int index = hashmap.get(root.val);
        
        root.left = buildNewTree(preorder,inorder,instart,index-1);
        root.right = buildNewTree(preorder,inorder,index+1,inend);
        return root;
    }
    
    
}
