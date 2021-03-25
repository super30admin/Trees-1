# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        q = []
        q.append([root, -math.inf, math.inf])
        while q:
            node, lower, upper = q.pop(0)
            if not node:
                continue
            value = node.val
            if value <= lower or value >= upper:
                return False
            q.append([node.left, lower, value])
            q.append([node.right, value, upper])
        return True

    """
    TC: O(N)
    SC: O(N)
    """