// Time complexity : O(n)  Traversing the node once
// Space Complexity : O(n) : Hashmap

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
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //Create a hashmap to store the inorder element and its index
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        
        return helper(preorder, map, 0, inorder.length - 1);
        
        
    }
    
    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map , int start, int end){
        
        // start and end are the pointers in the inorder to find the left and right subtrees
        // where as p is the pointing to the root of the current subtree.
        // Base case
        if (start >  end || p == preorder.length ){
            return null;
        }
        
        // Get the index of the root in inorder and create the root using that value
        int inorderIndex = map.get(preorder[p]);
        TreeNode root = new TreeNode(preorder[p]);
        
        // Update the index of the new root based on the subproblem before computing the left and right childs
        p++;
        
        // Compute the sub problems
        root.left = helper( preorder, map, start, inorderIndex - 1 );
        root.right = helper( preorder, map, inorderIndex + 1 , end);
            
        return root;
    }
}