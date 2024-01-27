#https://leetcode.com/problems/validate-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    previous = None
    flag = True
    
    def inOrder(self, root: TreeNode):
        if root == None:
            return
        self.inOrder(root.left)
        if self.previous != None and self.previous.val >= root.val:
            self.flag = False
        self.previous = root
        self.inOrder(root.right)
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inOrder(root)
        return self.flag

# Time complexity O(n)
# Space complexity O(h)