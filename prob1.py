# Time Complexity :O(n)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    prev = None
    flag = True
    
    def helper(self, root):
            #base
            if root is None:
                return
            #logic
            self.helper(root.left)
            if self.prev != None and self.prev.val >= root.val:
                self.flag = False 
            self.prev = root
            self.helper(root.right)
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag