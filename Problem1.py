#
# Time Complexity = O(n)
# Space Complexity = O(h)
# Works on leetcode
#
class Solution:
    def __init__(self):
        self.prev = None

    def isValidBST(self, root: TreeNode) -> bool:
        return self.inorder(root)

    def inorder(self, root):
        if not root:
            return True
        if not self.inorder(root.left):
            return False
        if self.prev != None and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.inorder(root.right)
