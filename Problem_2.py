
# 105. Construct Binary Tree from Preorder and Inorder Traversal

# code:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return 
        
        root = TreeNode(preorder.pop(0))
        
        idx = inorder.index(root.val)
        
        root.left = self.buildTree(preorder, inorder[:idx]) #Left subtree for the current root.
        root.right = self.buildTree(preorder, inorder[idx+1:]) #Right subtree for the current root.
        
        return root


# Time complexity: O(N) or O(H)  Height of the tree, number of elements in the array.
# Space complexity: O(1) No extra space 
# Accepted on Leetcode: Yes.