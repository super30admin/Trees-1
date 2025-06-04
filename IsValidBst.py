# Definition for a binary tree node.
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         flag = True 
#         prev = None
#         def inorder(root):
#             nonlocal flag , prev
#             # base
#             if not root : return 
#             # logic
#             inorder(root.left)
#             if prev and prev.val>=root.val:
#                 flag = False
#             prev = root
#             inorder(root.right)
#         inorder(root)
#         return flag

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         flag = [True] 
#         prev = [None]
#         def inorder(root):
#             # base
#             if not root : return 
#             # logic
#             inorder(root.left)
#             if prev[0] and prev[0].val>=root.val:
#                 flag[0] = False
#             prev[0] = root
#             inorder(root.right)
#         inorder(root)
#         return flag[0]

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         flag = True 
#         prev = None
#         def inorder(root):
#             nonlocal flag , prev
#             # base
#             if not root : return 
#             # logic
#             inorder(root.left)
#             if prev and prev.val>=root.val:
#                 flag = False
#             prev = root
#             if flag:
#                 inorder(root.right)
#         inorder(root)
#         return flag


# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         flag = True 
#         prev = None
#         def inorder(root):
#             nonlocal flag , prev
#             # base
#             if not root or not flag: return 
#             # logic
#             inorder(root.left)
#             print(root.val)
#             if prev and prev.val>=root.val:
#                 flag = False
#             prev = root
#             inorder(root.right)
#         inorder(root)
#         return flag

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         flag = True 
#         prev = None
#         def inorder(root):
#             nonlocal flag , prev
#             # base
#             if not root : return 
#             if flag:
#                 inorder(root.left)
#             print(root.val)
#             if prev and prev.val>=root.val:
#                 flag = False
#             prev = root
#             inorder(root.right)
#         inorder(root)
#         return flag

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         prev = None
#         def inorder(root):
#             nonlocal prev
#             # base
#             if not root : return True
#             left = inorder(root.left)
#             if prev and prev.val>=root.val:
#                 return False
#             prev = root
#             right = inorder(root.right)
#             return left and right
#         return inorder(root)

# def isValidBST(self, root: Optional[TreeNode]) -> bool:
#     prev = None
#     def inorder(root):
#         nonlocal prev
#         # base
#         if not root : return True
#         left = inorder(root.left)
#         if prev and prev.val>=root.val:
#             return False
#         prev = root
#         right = False
#         if left:
#             right = inorder(root.right)
#         return right
#     return inorder(root)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = None
        def inorder(root):
            nonlocal prev
            # base
            if not root : return True
            left = inorder(root.left)
            if prev and prev.val>=root.val:
                return False
            prev = root
            if not left: return False
            return inorder(root.right)
        return inorder(root)


