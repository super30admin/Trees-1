# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        # self.flag = True
        return self.helper(root)
    
    def helper(self, root: Optional[TreeNode]):
        # base case
        if root == None:
            return True
        
        # Traverse the left subtree
        if not self.helper(root.left):
            return False
        
        # Check if the current node's value is greater than the previous node's value
        if self.prev != None and self.prev.val >= root.val:
            # self.flag = False
            return False

        # Update the previous node
        self.prev = root

        # Traverse the right subtree
        return self.helper(root.right)
