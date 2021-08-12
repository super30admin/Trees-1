"""
Time Complexity : O(n)
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        val_index_dict = { num:idx for idx, num in enumerate(inorder) }
        self.idx = 0
        def helper(start:int, end:int):
            # Base
            if start > end:
                return None
            # Logic
            root = TreeNode(preorder[self.idx])
            self.idx += 1
            rootIdx = val_index_dict[root.val]
            root.left = helper(start, rootIdx - 1)
            root.right = helper(rootIdx + 1, end)
            return root
        return helper(0, len(inorder) - 1)
        