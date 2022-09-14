#Time Complexity: O(n)
#Space Complexity: O(n)
#Problem ran on leetcode with success

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
        
        self.inorder(root)
        return self.flag
    
    def inorder(self, root):
        if root is None:
            return
        if self.flag:
            self.inorder(root.left)
        if (self.prev is not None and self.prev.val >= root.val):
            self.flag = False
            return
        self.prev = root
        if self.flag:
            self.inorder(root.right)