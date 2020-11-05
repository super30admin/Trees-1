package Nov4;

import java.util.HashMap;
import java.util.Map;

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
    
/* 
	Time Complexity: O(n) where n is size of given arrays.
	Because we will process each element of the array once.

	Space Complexity: O(n) where n is size of given arrays.
	Because we are using extra space of hashmap of n size.
	      
	Did this code successfully run on Leetcode : Yes

	Any problem you faced while coding this : No

	Approach:
    Hashmap used to store elements of inorder array and their corresponding indexes.
    Global variable preIndex used to iterate through preorder array and find root node for each recursive call.
    After finding root, we will index of root in inorder array.
    Make recursive calls for left subtree and right subtree by iterating through start TO inIndex-1 and startIndex+1 TO end respectively.
 
*/
    
    int preIndex = 0;
    Map<Integer, Integer> hm;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
// creating and populating a hashmap with all elements of inorder array as the key and their indexes in inorder array as the value
        hm = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
    
       return helper(preorder, inorder, 0, inorder.length-1);
        
    }
    
    // HELPER FUNCTION 
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        // base condition for recursion for inorder array => when current subtree from inorder array has been processed
        if(start > end) {
            return null;
        }
         // base condition for recursion for preorder array => when all nodes in preorder have already been processed
        if (preIndex == preorder.length) {
            return null;
        }
        
        // create the current root node 
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        int inIndex = hm.get(root.val);
        root.left = helper(preorder, inorder, start, inIndex-1);
        root.right = helper(preorder, inorder, inIndex+1, end);
        
        return root;
        
    }
}