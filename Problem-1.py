# T.C = O(n) S.C = O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def __init__(self):

        self.prev = None
        self.flag = True

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.helper(root)
        return self.flag

    def helper(self,root):
        if not root or self.flag == False:
            return

        self.helper(root.left)
        print(root.val)
        if(self.prev is not None and self.prev.val >= root.val):
            self.flag = False

        self.prev = root
        self.helper(root.right)
        