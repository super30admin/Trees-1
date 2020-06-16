// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/**
 * Approach - first node of the preorder is root, find root in inorder, left sub array is left subtree, right subarray is right subtree
 * while moving to right to find next node right subarray of root, we need to skip number of elements which were considered for left subtree from the inorder (left subarray)
 */

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 *Given preorder and inorder traversal of a tree, construct the binary tree.
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return treeBuilderRecursive(preorder, inorder, 0, inorder.length-1, 0);
    }
    
    private TreeNode treeBuilderRecursive(int[] preoder, int[] inorder, int inStart, int inEnd, int preStart){
        
    	//base
    	// nothing left in inorder for this call or nothing left in the preorder (means all nodes visited)
    	if(inStart > inEnd || preStart >= preoder.length) 
            return null;
        
        //logic
        int val = preoder[preStart];
        //find this in inorder to get left and right subtree
        int inLoc = search(inorder, val);
        
        TreeNode node = new TreeNode(val);
    
        node.left = treeBuilderRecursive(preoder, inorder, inStart, inLoc-1, preStart+1);
        node.right = treeBuilderRecursive(preoder, inorder, inLoc+1, inEnd, preStart + (inLoc - inStart + 1));
        
        return node;
        
    }
    
    
    private int search(int[] arr, int key) {
        
        for(int i=0; i<arr.length;i++ ) {
            if(arr[i] == key) 
                return i;
        }
        
        return -1;
    }
}