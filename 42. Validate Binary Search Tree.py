# Time Complexity: O(n)
# Space Complexity: O(h)

# ------------------recursive limit approach-----------------
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)
        
    def helper(self, root, minn, maxx):
        
        if root is None: return True
        if (minn != None and minn >= root.val): return False
        if (maxx != None and maxx <= root.val): return False
        
        left = self.helper(root.left, minn, root.val)
        right = True
        if (left):
            right = self.helper(root.right, root.val, maxx)
        
        return left and right

# ------------------iterative approach--------------------
# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         prev = None
#         stack = []
#         while(root != None or len(stack) != 0):
#             while(root != None):
#                 stack.append(root)
#                 root = root.left
            
#             root = stack.pop()
#             if prev != None and prev.val >= root.val:
#                 return False
#             prev = root
#             root = root.right
#         return True


# ---------------recursive boolean function------------------
# class Solution:
#     def __init__(self):
#         self.prev = None
    
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
#         return self.inorder(root)
        
#     def inorder(self, root):
        
#         if root is None: return
#         print(root.val)
        
#         left_ = self.inorder(root.left)
        
#         if self.prev != None and self.prev.val >= root.val:
#             return False
            
#         self.prev = root
        
#         right_ = True
#         if left_:
#             right_ = self.inorder(root.right)
        
#         return left_ and right_


# -----------------recursive void function-------------------
# class Solution:
#     def __init__(self):
#         self.flag = True
#         self.prev = None
    
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
#         self.inorder(root)
#         return self.flag
        
#     def inorder(self, root):
#         if root is None: return
#         print(root.val)

#         if self.flag: self.inorder(root.left)
        
#         if self.prev != None and self.prev.val >= root.val:
#             self.flag = False

#         self.prev = root
        
#         if self.flag: self.inorder(root.right)


# --------------------In-order Traversal---------------------
# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         return self.inorder(root)
        
#     def inorder(self, root):
#         if root is None: return
        
#         self.inorder(root.left)
#         print("up")
#         print(root.val)
        
#         self.inorder(root.right)
#         print("down")
#         print(root.val)