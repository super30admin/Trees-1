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
	Map<Integer, Integer> valIndexMap = new HashMap<>();
	// index to keep track of preorder array - global so we can use same across all recursive calls
    int index;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	//create hashmap to retrieve index of the element from the inorder
        for(int i=0; i<inorder.length;i++ ){
           valIndexMap.put(inorder[i], i); 
        }
        return helper(preorder, inorder, 0, preorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        //if index reaches end of preorder (note index is global so shared across all recursive calls) , we exhausted all nodes
    	    // or if start crosses end means nothing on that side
    	    if(start > end || index == preorder.length) return null;
        
        //index of current node from the inorder
        int inIdx = valIndexMap.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index++]);
        
        //for left call it on elements left to inIdx vice versa for right
        root.left = helper(preorder, inorder, start, inIdx-1);
        root.right = helper(preorder, inorder, inIdx+1,end);
        
        return root;
    }
}