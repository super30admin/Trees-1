# Time complexity: O(n) where n=nodes in the tree
# Space complexity: O(log n) recursion stack holds only half the tree at any given instance

class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.val = value
        self.left = left
        self.right = right


class Solution:
    def validateBst(root):
        if not root:
            return True
        low, high = float('-inf'), float('inf')
        return self.bstHelper(root, low, high)

    def bstHelper(self, root, low, high):
        if not root:
            return True
        if not low < root.val < high:
            return False
        left = self.bstHelper(root.left, low, root.val)
        right = self.bstHelper(root.right, root.val, high)
        return left and right
