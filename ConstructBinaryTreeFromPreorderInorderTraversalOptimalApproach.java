// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this :


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
    
    //Approach we are using is to store the inorder in hashmap and use it to find the indices of left subtree ,indices of right subtree instead of creating different arrays in the approach that we did earlier.
    //The preorder index stored globally to find the root of the node, root at each subtree
    Map<Integer, Integer> inorderMap;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length ==0)
            return null;
        
        inorderMap = new HashMap<>();
        //storing inorder array to hashmap
        
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);  
        }
        //parameters: the last two are first index and last index
         return  helper(preorder, inorder, 0, inorder.length -1);            
 }
    
   private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
       //base
       if(start > end ) return null;
       
       
       //Getting root node from preorder and then incrementing after that
       
       int rootVal = preorder[preIdx];
       preIdx++;
       
       //Building the rootnode
       TreeNode root = new TreeNode(rootVal);
       
       //Inorder root idx
       int rootIdx = inorderMap.get(rootVal);
       
       //Getting left and right subtrees
       
       root.left = helper(preorder, inorder, start, rootIdx-1);
       root.right = helper(preorder, inorder, rootIdx+1, end); 
       
       return root;
       
       
       
   }
    
}
