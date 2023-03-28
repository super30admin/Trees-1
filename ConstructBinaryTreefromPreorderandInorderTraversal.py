# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
from typing import List

# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def build(preorder, inorder, p_start, p_end, i_start, i_end):
            if p_start > p_end:
                return None
            
            root_val = preorder[p_start]
            root = TreeNode(root_val)
            
            root_index = inorder.index(root_val)
            left_size = root_index - i_start
            
            root.left = build(preorder, inorder, p_start+1, p_start+left_size, i_start, root_index-1)
            root.right = build(preorder, inorder, p_start+left_size+1, p_end, root_index+1, i_end)
            
            return root
        
        return build(preorder, inorder, 0, len(preorder)-1, 0, len(inorder)-1)