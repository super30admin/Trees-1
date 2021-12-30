# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(n)
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = []
        prev = -sys.maxint-1
        while root != None or len(stack) !=0:
            while root!= None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= prev:
                return False
            else:
                prev = root.val
            root = root.right
        return True
        
        
