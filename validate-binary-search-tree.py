# Time Complexity : O(n) - n is number of nodes in tree
# Space Complexity : O(n) - n is number of nodes in tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Will do inorder traversal of tree and see if current node > prev node.
inorder traversal of BST gives nodes in ascending sorted order
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# void recursive function
class Solution(object):
    prev = None
    flag = True

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root)
        return self.flag

    def helper(self,root):
        if root is None:return

        self.helper(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        self.prev = root
        if self.flag:
            self.helper(root.right)

# boolean recursive function
class Solution(object):
    prev = None
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.helper(root)

    def helper(self,root):
        if root is None:return True

        left = self.isValidBST(root.left)
        if not left:
            return False

        if self.prev is not None and self.prev.val >= root.val:
            return False

        self.prev = root
        right = self.isValidBST(root.right)
        return right

