# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DEPTH
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        stack = []
        prev = float("-inf")
        current = root
        while stack or current:
            if current:
                stack.append(current)
                current = current.left
            else:
                current = stack.pop()
                if current.val <= prev:
                    return False
                prev = current.val
                current = current.right
        return True
        