'''
    Time Complexity:
        O(n) (where n = number of nodes in the Tree)

    Space Complexity:
        O(h) (where h = height of the Tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Check if left subtree is valid.
        Check if value of prev is less than root.
        Check if right subtree is valid.
        Perform this recursively in a DFS manner.
'''
MIN_INT = -float('inf')

class Solution:
    def __init__(self):
        self.prev = TreeNode(MIN_INT)

    def isValidBST(self, root: TreeNode) -> bool:
        return self.isValid(root)

    def isValid(self, root):
        if root is None:
            return True

        if not self.isValid(root.left):
            return False

        if self.prev.val >= root.val:
            return False

        self.prev = root
        return self.isValid(root.right)
