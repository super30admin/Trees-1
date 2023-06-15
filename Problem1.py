'''
Problem: Validate BST
Time Complexity: O(n), where n is number of nodes in a tree
Space Complexity: O(h), where h is height of the tree in recursion stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        boolean based recursion
        every node must fall within a range
        for left high changes to parent value
        for right low changes to parent value 
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root, low, high):
            if not root:
                return True
            
            if root.val<= low or root.val>=high:
                return False

            return helper(root.left, low, root.val) and helper(root.right, root.val, high)


        return helper(root,float('-inf'), float('inf'))