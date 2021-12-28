# Time Complexity : O(n)
# Space Complexity : O(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder is None or inorder is None or len(preorder) ==0:
            return None

        def helper(preord, inord):
      
            
            if not preord:
                return None

            root = TreeNode(preord[0])

            left_idx = inord.index(root.val)

            left_inorder = inord[:left_idx]
            right_inorder = inord[left_idx+1:]

            left_preorder = preord[1:1+len(left_inorder)]
            right_preorder = preord[1+len(left_inorder):]

            root.left = helper(left_preorder, left_inorder)
            root.right = helper(right_preorder, right_inorder)

            return root
        return helper(preorder, inorder)