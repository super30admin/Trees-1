# Time Complexity: O(n)
# Space Complexity: O(h)
# Maximum number of leaf nodes that can exist: 2**h 

# Definition for a binary tree node.
# Pre-order Traversal
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    sum = 0
    def sumNumbers(root):
        if root is None:
            return sum
        
        helper(root, 0)
        return sum

    def helper(root, num):
        # base
        if root is None:
            return 

        # logic
        if root.left is None and root.right is None:
            sum = sum + num*10 + root.val
            return
        
        helper(root.left, num*10 + root.val)
        helper(root.right, num*10 + root.val)



# # Inorder Traversal
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     sum = 0
#     def sumNumbers(root):
#         if root is None:
#             return sum
        
#         helper(root, 0)
#         return sum

#     def helper(root, num):
#         # base
#         if root is None:
#             return 

#         # logic        
#         helper(root.left, num*10 + root.val)

#         if root.left is None and root.right is None:
#             sum = sum + num*10 + root.val
#             return

#         helper(root.right, num*10 + root.val)



# # Postorder Traversal
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     sum = 0
#     def sumNumbers(root):
#         if root is None:
#             return sum
        
#         helper(root, 0)
#         return sum

#     def helper(root, num):
#         # base
#         if root is None:
#             return 

#         # logic        
#         helper(root.left, num*10 + root.val)
#         helper(root.right, num*10 + root.val)
#         if root.left is None and root.right is None:
#             sum = sum + num*10 + root.val
#             return
