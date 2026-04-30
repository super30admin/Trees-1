# Time Complexity: O(n)
# Space Complexity: O(n) 
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        
        self.flag=True
        self.prev= None

        def helper(root):
            if root == None:
                return
            helper(root.left)
            if self.prev!=None and root.val<=self.prev.val:
                self.flag=False
            self.prev=root
            helper(root.right)       
        
        
        helper(root)
        return self.flag
        