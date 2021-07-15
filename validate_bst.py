#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.result = True
        self.prev = float('-inf')
        

    def inorder(self,root):
        if not root:
            self.result = True
            return 
        self.inorder(root.left)
        if root.val<=self.prev:
            self.result = False
            return 
        self.prev = root.val
        
        self.inorder(root.right)
        return
    
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        self.inorder(root)
        return self.result
    
    