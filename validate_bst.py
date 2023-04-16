# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In the following code, we are using the inorder traversal of the tree to check if the tree is a valid BST or not.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return

        self.ordered = True
        self.previous = None

        self.inorder(root)

        return self.ordered

    def inorder(self, root: Optional[TreeNode]) -> bool:
        if self.ordered == False:
            return

        if root == None:
            return

        self.inorder(root.left)
        
        if self.previous != None and self.previous.val >= root.val:
            self.ordered = False

        self.previous = root

        self.inorder(root.right)