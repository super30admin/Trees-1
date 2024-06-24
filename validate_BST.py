"""
Trees-1
Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Time Complexity : O(n) where n is no of elements in tree
Space Complexity : O(h) where h is recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
For find validity approach, trick is to keep track of min and max in two variables and start recursively calling left and
right by keeping min as none for left and max as none for right and check if root.val is not <= min and >= max then it's an
invalid BST else after completing recursion return true. 
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False
        stack = []
        prev = None
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev is not None and prev.val >= root.val:
                return False
            prev = root
            root = root.right

        return True
        
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root):
            if root is None:
                return
            inorder(root.left)
            if self.prev is not None and self.prev.val >= root.val:
                self.isValid = False
                return
            self.prev = root
            inorder(root.right)
        
        if not root:
            return False

        self.prev = None
        self.isValid = True
        inorder(root)
        return self.isValid
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: # O(n) #O(h)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def find_validity(root, min, max):
            if root is None:
                return
            find_validity(root.left, min, root.val)
            if (min is not None and root.val <= min) or (max is not None and root.val >= max):
                self.isValid = False
                return
            find_validity(root.right, root.val, max)
        
        if not root:
            return True
        
        self.isValid = True
        find_validity(root, None, None)
        return self.isValid
        

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:  # O(n) #O(h)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def find_validity(root, min, max):
            if root is None:
                return True
            
            if (min is not None and root.val <= min) or (max is not None and root.val >= max):
                return False
            return find_validity(root.left, min, root.val) and find_validity(root.right, root.val, max)
        
        if not root:
            return True

        return find_validity(root, None, None)
        