#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    prev = None
    isValid = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.isValid = True
        self.prev = None
        if root == None:
            return True
        self.inorder(root)
        
        return self.isValid
        
        
    def inorder(self,root):
        
        if root == None:
            return 
        
        self.inorder(root.left)
        
        if (self.prev!= None and self.prev.val>=root.val):
            self.isValid = False
            return
        
        self.prev = root
        if self.isValid:
            self.inorder(root.right)