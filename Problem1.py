#98. Validate Binary Search Tree

# Definition for a binary tree node.
import math
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        min = -math.inf
        max = math.inf

        return self.validateBST(root,min,max)
    
    def validateBST(self,root,min,max):
        
        if root.val<=min or root.val=>max:
            return False
        validateLeftNode = True
        if root.left != None:
            validateLeftNode = validateBST(root.left, min, root.val)

        if not validateLeftNode:
            return False
        validateRightNode = True
        if root.right != None:
            validateRightNode = validateBST(root.right, root.val, max)

        return validateRightNode