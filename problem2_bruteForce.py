"""
Time Complexity  : O(n^2) where n is the number of elements in the tree. n^2 because for every node we are finding out the root index in inorder traversal array
Space Complexity : O(n^2) where n is the number of elemenets in the tree. For every node we are creating 4 different new arrays.
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
preorder traversal's first node is always the root node.
1. Find the root using Preorder traversal
2. Calculate the inOrderLeft, preOrderLeft, inOrderRight, preOrderRight arrays.
3. Find the left and right elements of the root by calling buildTree function in recursive manner.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return 
        
        rootIdx = 0 
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        
        #Find the root node's index in preorder
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                rootIdx = i
                break
        
        inL = inorder[0:rootIdx]
        preL = preorder[1:rootIdx+1]
        inR = inorder[rootIdx + 1: len(inorder)]
        preR = preorder[rootIdx+1:len(preorder)]
        
        root.left = self.buildTree(preL, inL)
        root.right = self.buildTree(preR, inR)

        return root
        
        