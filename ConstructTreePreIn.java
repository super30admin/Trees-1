// Time Complexity: For Recursive, O(n).
// Space Complexity: For Recursive, O(n) - Recursion Stack Space + O(n) - Ausiliary Stack Space
// Did this code successfully run on Leetcode: Yes
// Any problems faced: No

import java.util.Arrays;

public class ConstructTreePreIn {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	class RecursiveSolution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder.length == 0 || inorder.length == 0) return null;
	        int index = -1;
	        TreeNode root = new TreeNode(preorder[0]);
	        for(int i = 0; i < inorder.length; i++){
	            if(inorder[i] == preorder[0]){
	                index = i;
	            }
	        }
	        
	        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
	        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
	        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
	        int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
	        
	        root.right = buildTree(preRight, inRight);
	        root.left = buildTree(preLeft, inLeft);
	        return root;
	    }
	}
}
