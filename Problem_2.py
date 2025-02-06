"""
## Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   """
   TC: O(N^2)
   SC: O(N^2)
   """
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(preorder, start, end):
            nonlocal idx
            nonlocal idx_map
            # base condition
            if start > end  or idx == len(preorder): return None
            #logic

            root = TreeNode(preorder[idx])
            idx += 1
            root_idx = idx_map[root.val]
            root.left = helper(preorder, start, root_idx - 1)
            root.right= helper(preorder, root_idx + 1, end)

            return root

        idx = 0
        idx_map = {}
        for i in range(len(inorder)):
            idx_map[inorder[i]] = i

        return helper(preorder, 0, len(preorder))

        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   """
   TC: O(N)
   SC: O(N)
   """
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(preorder, start, end):
            nonlocal idx
            nonlocal idx_map
            # base condition
            if start > end  or idx == len(preorder): return None
            #logic

            root = TreeNode(preorder[idx])
            idx += 1
            root_idx = idx_map[root.val]
            root.left = helper(preorder, start, root_idx - 1)
            root.right= helper(preorder, root_idx + 1, end)

            return root

        idx = 0
        idx_map = {}
        for i in range(len(inorder)):
            idx_map[inorder[i]] = i

        return helper(preorder, 0, len(preorder))

        
            
            
                    
            
        