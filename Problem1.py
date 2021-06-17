# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# doing inorder travesal and checking if it is sorted or not
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
    def isValidBST(self, root: TreeNode) -> bool:
        return self.inOrder(root)
    def inOrder(self,root):
        if root == None:
            return True
        if self.inOrder(root.left) == False:
            return False
        if self.prev != None and root.val <= self.prev:
            return False
        self.prev = root.val
        return self.inOrder(root.right)
        
        
        