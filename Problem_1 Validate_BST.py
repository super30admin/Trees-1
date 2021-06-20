# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english
# Root Value should be in between minimum and maximum values
# At each node we can ascertain min and max value range for it to be a BST. If any nodes fails then it is not BST
# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root):
        return self.isValid(root, None, None)

    def isValid(self, root, minValue, maxValue):
        if root == None: return True
        if minValue != None and root.val <= minValue: return False
        if maxValue != None and root.val >= maxValue: return False
        return self.isValid(root.left, minValue, root.val) and self.isValid(root.right, root.val, maxValue)