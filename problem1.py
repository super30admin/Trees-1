# Time Complexity = O(n)
# Space Complexity = O(h)

class Solution:
    isValid = True
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if(root ==None):
            return True
        self.inorder(root)
        return self.isValid
        
        
    def inorder(self,root):
        if(root==None):
            return 
        self.inorder(root.left)
        if(self.prev!=None and root.val<=self.prev.val):
            self.isValid= False
            return 
        if(self.isValid==True):
            self.prev = root
            self.inorder(root.right)
        else:
            return 
            
        
        