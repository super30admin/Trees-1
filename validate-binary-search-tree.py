# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    # prev=None
    # flag=True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev=None
        self.flag=True
        self.helper(root)
        return self.flag
    def helper(self,root: Optional[TreeNode]):
        if root==None: return 
        self.helper(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            self.flag=False
        self.prev=root
        if self.flag:
            self.helper(root.right)
    
        