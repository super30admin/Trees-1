# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#---------------Using None as return type-------------------------------
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.isValid = True
        self.inorder(root)    
        return self.isValid

    def inorder(self, root: Optional[TreeNode]) -> None:
        # base case
        if root == None:
            return
        self.inorder(root.left)
        print(root.val, "up")
        if self.prev != None and self.prev.val >= root.val:
            self.isValid = False
            return
        self.prev = root
        self.inorder(root.right)
        print(root.val, "down")
#------------------ Using bool as return type-----------------    
# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.prev = None
              
#         return self.inorder(root)

#     def inorder(self, root: Optional[TreeNode]) -> bool:
#         # base case
#         if root == None:
#             return True

#         left = self.inorder(root.left)
        
#         if self.prev != None and self.prev.val >= root.val:     
#             return False
#         self.prev = root
#         print(root.val)
#         if left != False:
#             right = self.inorder(root.right)
#         return left and right