# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        
        def helper(left, right):
            if left > right:
                return None
            
            nonlocal pre_idx
            
            root_val = preorder[pre_idx]
            root = TreeNode(root_val)
            pre_idx += 1
            
            index = imap[root_val]
            
            root.left = helper(left, index-1)
            root.right = helper(index+1, right)
            
            return root
        
        pre_idx = 0
        imap = {}
        for idx, val in enumerate(inorder):
            imap[val] = idx
        return helper(0, len(inorder)-1)
            
