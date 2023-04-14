# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    prev = None
    flag = True
            
    def isValidBST(self, root):
        self.helper(root)
        return self.flag

    def helper(self,root):
        if root == None:
            return None
        
        if self.flag:
            self.helper(root.left)

        if self.prev != None and self.prev.val >= root.val:
            self.flag = False

        if self.flag:
            self.prev = root
            self.helper(root.right)





        """
        :type root: TreeNode
        :rtype: bool
        """
        