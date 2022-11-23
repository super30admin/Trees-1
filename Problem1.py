#Time complexity: O(n)
#Space complexity: O(h) - height of the tree

#Accepted on Leetcode

#Approach
#Inororder traversal of a valid BST is always ascending
#Use this fact either recursively or iteratively (if violated - not BST) to solve the problem

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValidTree = True
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root, float('-inf'), float('inf'))
        

    def validate(self, root, minVal, maxVal):
        if root == None:
            return True

        if root.val <= minVal or root.val >= maxVal:
            return False

        return self.validate(root.left, minVal, root.val) and self.validate(root.right, root.val, maxVal)
        
