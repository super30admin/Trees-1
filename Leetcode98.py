# Time complexity = O(n)
# Space Complexity = O(h) h is height of the tree

#Approach - we are using recursive helper function that validates each node by ensuring its value falls within a given range,
#initially set to float("-inf") , float("inf") As recursion progresses, the valid range is updated based on the node values to enforce 
# BST properties, with the left subtree constrained by the parent node's value as the upper limit and the right subtree by the parent node's 
# value as the lower limit.


# Definition for a binary tree node.s
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(node,left,right):
            if not node:
                return True 
            if not (left < node.val < right):
                return False 
            return isValid(node.left, left, node.val) and isValid(node.right,node.val,right)
        return isValid(root,float("-inf") , float("inf"))
