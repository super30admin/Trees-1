# https://leetcode.com/problems/validate-binary-search-tree/

# Time Complexity : O(n)
# Space Complexity : O(h) h = height of the tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        min_val = float('-inf')
        max_val = float('inf')
        return self.BSTfn(root,min_val,max_val)
    
    def BSTfn(self, root: Optional[TreeNode],min_val,max_val) -> bool:
        if(root == None):
            return True
        if min_val >= root.val or max_val <= root.val:
            return False
        return self.BSTfn(root.left,min_val,root.val) and self.BSTfn(root.right,root.val,max_val)
    


# conditional inorder recursion solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__ (self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag

    def inorder(self, root: Optional[TreeNode]):
        if root is None:
            return True
        left = self.inorder(root.left)
        if (self.prev is not None and root.val <= self.prev.val):
            self.flag = False
            #return
        self.prev = root
        #right = self.inorder(root.right)
        return left and self.inorder(root.right)
        
        