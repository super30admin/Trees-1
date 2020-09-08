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
        
        current = root
        previous = None
        stack = []
        
        while stack or current:
            if current:
                stack.append(current)
                current = current.left
                
            else:
                current = stack.pop()
                if(previous and previous.val >= current.val):
                    return False
                previous = current
                
                current = current.right
        
        return True
        
