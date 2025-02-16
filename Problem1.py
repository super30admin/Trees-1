# 98. Validate Binary Search Tree

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Top-Down Recursive Approach - DFS
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def validate(root, left, right):
            if root == None:
                return True

            if root.val <= left or root.val >= right:
                return False

            return validate(root.left, left, root.val) and validate(root.right, root.val, right)

        return validate(root, float('-inf'), float('inf'))
    
# Bottom-Up Iterative Approach - BFS
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        stack = [(root, float('-inf'), float('inf'))]

        while stack:
            root, left, right = stack.pop()

            if root == None:
                continue
            
            if root.val <= left or root.val >= right:   
                return False
            
            stack.append((root.left, left, root.val))
            stack.append((root.right, root.val, right))

        return True
    
# Inorder Traversal Approach
class Solution:
    def __init__(self):
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        if not self.isValidBST(root.left):
            return False
        
        if self.prev != None and self.prev.val >= root.val:
            return False
        
        self.prev = root
        
        return self.isValidBST(root.right)

