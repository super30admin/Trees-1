
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:


    def isValidBST(self, root) :

        return self.rangeBST(root, float("-inf"), float("inf"))


    def rangeBST(self, root, min_val, max_val):

        if not root:
            return True

        if not min_val <= root.val <= max_val:
            return False

        return self.rangeBST(root.left, min_val, root.val) and self.rangeBST(root.right, root.val, max_val)

sol=Solution()
l = TreeNode(1, None, None)
r = TreeNode(3, None, None)
a = TreeNode(2, l, r)

print (sol.isValidBST(a))