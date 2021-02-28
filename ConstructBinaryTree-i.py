# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(n)
# LeetCode: Y(https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
# Approach: For a preorder traversal, the root is the first element
#           For inorder traversal, the elements to the left are a part of left subtree and elements to the right are a part of the right subtree
#           Traverse the preorder from right to right and finding the range of left subtree and right subtree nodes in the inorder 
class Solution:
    
    def __init__(self):
        self.idx = 0
        self.map = {}
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        # base case
        if not inorder or not preorder or not len(inorder) or not len(preorder) or (len(inorder) != len(preorder)):
            return None
        
        # construct value to index mapping for inorder traversal
        for index, value in enumerate(inorder):
            self.map[value] = index
            
        return self.helper(preorder, 0, len(inorder) - 1)
            
    def helper(self, preorder: List[int], start: int, end: int) -> TreeNode:
        
        # check for valid range
        if start > end:
            return None
            
        # get root value of current index
        root_val = preorder[self.idx]
        
        # construct a new TreeNode
        root = TreeNode(root_val)
        
        # update idx
        self.idx += 1
        
        # process left subtree
        root.left = self.helper(preorder, start, self.map[root_val] - 1)
        
        # process right subtree
        root.right = self.helper(preorder, self.map[root_val] + 1, end)
        
        # return root
        return root
            
        
