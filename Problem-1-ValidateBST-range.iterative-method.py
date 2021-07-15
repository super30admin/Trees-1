# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def isValidBST(self, root) :

        return self.rangeBSTIterative(root)

    def rangeBSTIterative(self, root):
        min_val = float("-inf")
        max_val = float("inf")
        stack = []
        stack.append((root, min_val, max_val))

        while stack:
            curr_root, curr_min, curr_max = stack.pop()

            if curr_min >= curr_root.val or curr_root.val > curr_max:
                return False

            if curr_root.left:
                stack.append((curr_root.left, curr_min, curr_root.val - 1))

            if curr_root.right:
                stack.append((curr_root.right, curr_root.val, curr_max))

        return True
sol=Solution()
l = TreeNode(1, None, None)
r = TreeNode(3, None, None)
a = TreeNode(2, l, r)

print (sol.isValidBST(a))