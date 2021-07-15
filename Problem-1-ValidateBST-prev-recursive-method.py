# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    prev = None
    result = True

    def isValidBST(self, root):

        self.validBSTrec(root)
        return self.result

    def validBSTrec(self, root):

        if not root:
            return

        self.validBSTrec(root.left)

        if self.prev and self.prev.val >= root.val:
            self.result = False
            return self.result
        self.prev = root
        self.validBSTrec(root.right)
sol=Solution()
l = TreeNode(1, None, None)
r = TreeNode(3, None, None)
a = TreeNode(2, l, r)

print (sol.isValidBST(a))