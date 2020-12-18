# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach 1: Iterative
# In this approach we will do a normal inorder traversal of BST with an added condition in between. We will take advantage of the values traversed in inorder fashion where previous value is always less than the current value we are traversing. That means left child < root < right child, in our inorder traversal

# Time Complexity: O(n)
# Space Complexity: O(h); h = height of the tree

# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         stack = []
#         prev = None
        
#         while root != None or len(stack) != 0:
#             while root != None:
#                 stack.append(root)
#                 root = root.left
                
#             root = stack.pop()
#             if prev != None and (prev.val >= root.val):
#                 return False
            
#             prev = root
#             root = root.right
            
#         return True
    
# Approach 1: Recurssive (Same apporach)
# In this approach we will do a normal inorder traversal of BST with an added condition in between. We will take advantage of the values traversed in inorder fashion where previous value is always less than the current value we are traversing. That means left child < root < right child, in our inorder traversal

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None
        return self.inorder(root)
    
    def inorder(self, root):
        if root == None:
            return True
        
        if not self.inorder(root.left):
            return False
        
        if (self.prev != None and self.prev.val >= root.val):
            return False
        
        self.prev = root
        return self.inorder(root.right)
        