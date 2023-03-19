# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        return self.inorder(root)

    def inorder(self, root):
        if root is None:
            return True

        if not self.inorder(root.left):
            return False

        if self.prev is not None and root.val <= self.prev.val:
            return False

        self.prev = root

        return self.inorder(root.right)

# TC =O(n).
# Space complexity : O(1). Height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
