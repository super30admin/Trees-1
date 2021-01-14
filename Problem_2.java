// Time Complexity :O(n)
// Space Complexity :)(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//I used the hashmap to store all the keys and indexes of the indeorder traversal to avoid the loop iteration again and again.
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
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Base cases
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }        
        return buildTreeUtil(preorder, 0, inorder.length-1);      
    }
    public TreeNode buildTreeUtil(int[] preorder, int start, int end){
 
        if(start > end)
            return null;
        
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        
        if(start == end)
            return node;
        
        int inOrderIndex = map.get(node.val);
        
        TreeNode left = buildTreeUtil(preorder, start, inOrderIndex-1);
        TreeNode right = buildTreeUtil(preorder, inOrderIndex+1, end);
        
        node.left = left; 
        node.right = right; 
        
        return node;
    }
}