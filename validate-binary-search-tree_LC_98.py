#TC:O(n)as it travers through each node only once.
#SC:(h)height of the tree as it stored max of left values

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Traversal of DFS

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         if not root:
#             return True
#         self.inorder(root)  

        
#     def inorder(self, root: Optional[TreeNode]):
#             if not root:
#                 return 
#             self.inorder(root.left)
#             print(root.val)
#             self.inorder(root.right)


# validate Binary tree Recursion:
class Solution:
    isValid=True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev=None    
        if not root:
            return True
        self.inorder(root)
        return self.isValid
         

    def inorder(self,root):
        if not root:
            return 
        self.inorder(root.left)
        if self.prev is not None and self.prev.val>=root.val:
            self.isValid = False
            print("hello")
            return 
        self.prev=root
        self.inorder(root.right)        

# validate Binary tree iterative :
# class Solution:
#      def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         stack = []
#         prev = None
#         while stack or root:
#             while root:
#                 stack.append(root)
#                 root = root.left
#             root = stack.pop()
#             if (prev is not None and prev.val >= root.val):
#                 return False
#             prev = root
#             root = root.right
#         return True       

