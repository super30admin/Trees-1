'''
105. Construct Binary Tree from Preorder and Inorder Traversal
Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        '''
        Intuition:
        The first element of the preorder list is the root of the tree. We can find this root in the inorder list to determine the left and right subtrees.
        Approach:
        1. Use a recursive function that takes the current range of indices for preorder and inorder lists.
        2. The base case is when the start index exceeds the end index, indicating no nodes to process.
        3. Create a new TreeNode with the current root value from preorder.
        4. Find the index of this root in inorder to split the left and right subtrees.
        5. Recursively build the left and right subtrees using updated indices.
        '''
        def helper(pre_start, pre_end, in_start, in_end):
            if pre_start > pre_end or in_start > in_end:
                return None
            
            root_val = preorder[pre_start]
            root = TreeNode(root_val)
            
            # Find the index of the root in inorder
            root_index = inorder.index(root_val, in_start, in_end + 1)
            left_size = root_index - in_start
            
            # Recursively build left and right subtrees
            root.left = helper(pre_start + 1, pre_start + left_size, in_start, root_index - 1)
            root.right = helper(pre_start + left_size + 1, pre_end, root_index + 1, in_end)
            
            return root
        
        return helper(0, len(preorder) - 1, 0, len(inorder) - 1)
        # Start the recursion with the full range of both lists