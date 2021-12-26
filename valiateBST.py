# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    bool_ = True
    prev = None
    def inorder(self,root):
        # self.bool_ = False
        if root == None:
            return
        else:

            self.inorder(root.left)
            if (self.prev!=None and self.prev >= root.val):
                self.bool_ = False
                return
            self.prev = root.val
            self.inorder(root.right)


    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        self.inorder(root)

        return self.bool_

