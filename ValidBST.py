
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

// 
class Solution(object):
    prev = None
    def isValidBST(self, root):
        return self.helper(root)
    
    def helper(self,root): 
        if not root:
            return True
        if not self.helper(root.left):
            return False
        if(self.prev != None and root.val <=self. prev.val):
            
            return False
        
        self.prev = root
        return self.helper(root.right)
