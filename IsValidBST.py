# All solutions:
# TC : O(n) ; n = number of elements in tree
# SC : O(h) ; h = height of tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        prev = None
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False
            
            prev = root
            root = root.right
            
        return True
    
# Recursive
# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         prev = [None]
#         return self.inorder(root, prev)
    
#     def inorder(self, root, prev):
#         if root == None:
#             return True
        
#         if self.inorder(root.left, prev) == False:
#             return False
        
#         if prev[0] != None and prev[0].val >= root.val:
#             return False
        
#         prev[0] = root
#         return self.inorder(root.right, prev)

# Recursive : Local Max and Min
# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         return self.valid(root, None, None)
    
#     def valid(self, root, Min, Max):
#         if root == None:
#             return True
        
#         if Min != None and Min.val >= root.val:
#             return False
        
#         if Max != None and Max.val <= root.val:
#             return False
        
#         return self.valid(root.left, Min, root) and self.valid(root.right, root, Max)