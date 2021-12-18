class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root) -> bool:
        # Time Complexity = O(n)
        # Space Complexity = O(h) - where h is the height of the tree

        if root is None:
            return True

        # Stack to be used
        s = []
        prev = None
        while root or len(s) > 0:
            # Go to the left until we reach null
            while root:
                s.append(root)
                root = root.left

            # Once we reach null on the left side
            root = s.pop()
            if prev is not None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
