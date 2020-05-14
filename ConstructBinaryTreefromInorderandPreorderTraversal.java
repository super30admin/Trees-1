package s30Coding;

import java.util.*;

//Time Complexity :- O(n) where n is number of elements in the list
//Space Complexity :- O(h) where h is height of the tree

//Leet Code: yes

public class ConstructBinaryTreefromInorderandPreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 HashMap<Integer,Integer> map;
	    int index = 0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder.length == 0) return null;
	        map = new HashMap<>();
	        for(int i = 0; i < inorder.length; i++){
	            map.put(inorder[i],i);
	        }
	        return helper(preorder, 0, inorder.length  -1);
	    }
	    private TreeNode helper(int[] preorder,int start, int end){
	        //base
	        if(start > end || index == preorder.length){
	            return null;
	        }
	        //logic
	        int inIdx = map.get(preorder[index]);
	        TreeNode root = new TreeNode(preorder[index]);
	        index++;
	        root.left = helper(preorder, start, inIdx -1);
	        root.right = helper(preorder, inIdx+1, end);
	        return root;
	        
	    }
}
