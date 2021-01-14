/**
Leetcode 105: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Collabedit: http://collabedit.com/y6pk6

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    private Map<Integer, Integer> indexMap = new HashMap<>();
    private int index =0;
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        for(int i =0;i < inorder.length; i++)
            this.indexMap.put(inorder[i], i);
            
        return buildTreeHelper( preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end)
    {
    
        if(start > end) return null;
        
        int rootValue = preorder[this.index];
        
        this.index++;
        
        int indexInOrder = this.indexMap.get(rootValue);
        
        TreeNode root = new TreeNode(rootValue);
        
        root.left = buildTreeHelper(preorder, inorder, start, indexInOrder-1 );
        
        root.right = buildTreeHelper(preorder, inorder, indexInOrder+1, end );
        
        return root;
    
    }
}
