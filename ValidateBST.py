# Time Complexity: O(n), n of nodes visited in the tree
# Spcae Complexity: O(h), h: height of the tree
    # Worst Case: O(h) = O(n) - Unbalanced Tree
    # Best Case: O(log n) - Balanced Tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.inOrder(root)
        return self.flag
    
    def inOrder(self, root: Optional[TreeNode]):
        # base
        if root == None:
            return
        # logic
        self.inOrder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        # If the breach is happened don't do the right recursive call
        # if self.flag:
        self.inOrder(root.right)
