# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Optimal solution accepted by leetcode
#Time complexity - O(n) since we are traversing through every node
#Space complexity - O(1) is constant because we are just storing min and max val

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, None, None)
    def helper(self, root, minVal, maxVal):
        if root == None:
            return True
        if minVal != None and root.val <= minVal:
            return False
        if maxVal != None and root.val >= maxVal:
            return False
        return self.helper(root.left, minVal, root.val) and self.helper(root.right, root.val, maxVal)