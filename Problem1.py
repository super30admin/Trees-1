#Time Complexity :O(n)
#Space Complexity :O(h) h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev=None 
        return self.inorder(root) 

    def inorder(self,root):
        if root==None:
            return True

        left=self.inorder(root.left) 

        if self.prev is not None and self.prev.val>=root.val:
            return False
        self.prev=root

        right=self.inorder(root.right)

        return left and right
