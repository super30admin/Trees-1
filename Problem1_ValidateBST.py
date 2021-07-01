# Time Complexity: O(n), where n is number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Solution:

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None
        return self.helper(root)

    # Recursively check if every node satisfies the BST condition
    def helper(self, root: TreeNode) -> bool:
        if not root:
            return True

        if not self.helper(root.left):
            return False

        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root

        return self.helper(root.right)