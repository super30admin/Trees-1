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
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.helper(root, None, None)
    
    def helper(self, root, min, max):
        if root is None:
            return True
        if min is not None and root.val <= min:
            return False
        if max is not None and root.val >= max:
            return False
            
        return self.helper(root.left, min, root.val) and self.helper(root.right, root.val, max)
            
            
        
        