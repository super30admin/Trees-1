"""
Implemented with reference to the homework solution.
Time Complexity: O(n)
Space Complexity: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        def helper(prestart, preend, instart, inend):
            if prestart > preend or instart > inend:
                return None

            root_val = preorder[prestart]
            root = TreeNode(root_val)
            rootidx = inorder_map[root_val]
            num_left = rootidx - instart

            root.left = helper(prestart + 1, prestart + num_left, instart, rootidx - 1)
            root.right = helper(prestart + num_left + 1, preend, rootidx + 1, inend)

            return root

        return helper(0, len(preorder) - 1, 0, len(inorder) - 1)
        