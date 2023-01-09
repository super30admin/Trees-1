#Time complexity: O(n)
#space complexity: O(h) where h=height of the tree
#ran on leetcode: Yes
#do a inorder traversal tracking the previous and currrent element. An inorder traversal
#of BST would give the values in increasing order. So if prev.val>=curr.val then set result to false, else result is true.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rec(self,root):
        if(root==None):
            return
        self.rec(root.left)
        if(self.prev and self.prev.val>=root.val):
            self.valid=False
            return
        self.prev=root
        self.rec(root.right)
        

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.valid=True
        self.prev=None
        self.rec(root)
        return self.valid
