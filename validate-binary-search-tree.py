'''
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
'''
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper_inorder(root)
        return self.flag
    
    def helper_inorder(self, root):
        # base case
        if root == None: return
        # logic
        # go down the left subtree
        self.helper_inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False

        self.prev=root

        # go right only if we haven't breached the condition yet
        if self.flag:
            self.helper_inorder(root.right)
