# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    prev = TreeNode()
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def check(root):
            if not root: return
            check(root.left)
            if (self.prev != None and self.prev.val >= root.val):
                flag = False
                return
            self.prev = root
            check(root.right)
    
        flag = True
        check(root)
        return flag