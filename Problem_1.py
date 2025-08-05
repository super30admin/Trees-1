# // Time Complexity : O(n)
# // Space Complexity : O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    prev = float('-inf')
    isValid = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
       self.inOrder(root)
       return self.isValid
        
        
        
    def inOrder(self,root):
        if(self.isValid == False):
            return False
        if(root.left is not None):
            self.inOrder(root.left)
        if(root.val > self.prev):
            self.prev = root.val
        else:
            self.isValid = False
        if(root.right is not None):
            self.inOrder(root.right)



     


        