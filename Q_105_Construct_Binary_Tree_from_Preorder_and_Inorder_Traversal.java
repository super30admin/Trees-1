package Q_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.Arrays;
import java.util.HashMap;


//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7

//Time Complexity  : O(n)  
//Space Complexity : O(n)

public class Solution {
	

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public HashMap<Integer, Integer> createMap(int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<inorder.length;i++)
		{
			map.put(inorder[i], i);
		}
		return map;
	}
	
	public TreeNode helper(int[] preorder, int[] inorder) {
		if(preorder.length ==0 || inorder.length ==0)
		{
			return null;
		}
		
		HashMap<Integer, Integer> map =createMap(inorder);
		int index = map.get(preorder[0]);
		TreeNode root = new TreeNode(preorder[0]);
		
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, index); 
		int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
		int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index+1);
		int[] rightPreorder = Arrays.copyOfRange(preorder, index+1, preorder.length);
		
//		root.left = 
		root.left = helper(leftPreorder, leftInorder);
		root.right = helper(rightPreorder, rightInorder);
		return root;
	}
	

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		//map Creation
		
		return helper(preorder, inorder);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		Solution s = new Solution();
		System.out.println(s.buildTree(preorder, inorder));

	}

}
