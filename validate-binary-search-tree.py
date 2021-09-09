# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    prev = None
    flag = True
    
    def helper(self, root: TreeNode):
        
        if (root == None):
          #  print("first")
            return

        self.helper(root.left)
   
        if self.prev != None and self.prev >= root.val:
         #   print("second")
            self.flag = False
            return

            
       # print(root.val, self.prev)
        self.prev = root.val
        
        self.helper(root.right)
        
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None or (root.left == None and root.right == None):
            return True
        
        self.helper(root)
        
        return self.flag
        
    
        
        
        