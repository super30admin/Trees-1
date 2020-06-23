#LC 98. Validate Binary Search Tree
#Time complexity - O(n)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.prev = None
        def inorder(root):
            if not root:
                return True
            
            if inorder(root.left) == False:
                return False
            
            if self.prev != None and root.val <= self.prev.val:
                return False
            self.prev = root
            return inorder(root.right)
        return inorder(root)