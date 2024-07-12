# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True

        def Inorder(root):
            if not root:
                return 
            
            Inorder(root.left)
            
            if self.prev and self.prev.val >= root.val:
                self.flag = False
            
            self.prev = root
            Inorder(root.right)
        
        Inorder(root)
        return self.flag