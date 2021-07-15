class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def isValidBST(self, root):
        stack = []
        prev = None

        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
sol=Solution()
l = TreeNode(1, None, None)
r = TreeNode(3, None, None)
a = TreeNode(2, l, r)

print (sol.isValidBST(a))