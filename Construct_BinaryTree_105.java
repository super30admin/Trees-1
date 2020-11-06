package com.s30.satish;

import java.util.HashMap;

//class TreeNode
//{
//	int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() 
//    {
//    	
//    }
//    TreeNode(int val) 
//    { 
//    	this.val = val; 
//    }
//    TreeNode(int val, TreeNode left, TreeNode right) 
//    {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }	      
//}
class Construct_BinaryTree_105 {
	HashMap<Integer, Integer> map = new HashMap<>();
	int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	for(int i = 0; i < inorder.length; i++)
    		map.put(inorder[i], i);
    	
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        if(start > end)
        	return null;
        int rootValue = preorder[index];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        index++;
        
        root.left = helper(preorder, inorder, start, rootIndex - 1);
        
        root.right = helper(preorder, inorder, rootIndex + 1, end);
        
        return root;
    }
}
