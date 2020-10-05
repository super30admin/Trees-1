#Complexity is amortised O(n) where n is the size of inorder array. 
# It can be optimized to O(n) by using hashtable to find index of preorder[0] and using start and end indices instead of slicing
#Space -O(n) to create Binary Tree
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not len(preorder):
            return
        i = inorder.index(preorder[0])
        root = TreeNode(inorder[i])
        root.left = self.buildTree(preorder[1:i+1],inorder[:i])
        root.right = self.buildTree(preorder[i+1:],inorder[i+1:])
        return root
        
        
        