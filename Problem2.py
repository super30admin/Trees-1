# Leetcode 98: Validate Binary Search Tree
# Time -> O(n)
# Space -> O(n)

class Solution:
    
    prev = float('-inf')
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        
        def helper(root):
            
            if root == None:
                
                return True
            
            left = helper(root.left)
            
            if (self.prev >= root.val):
                
                return False
            
            self.prev = root.val
            
            right = helper(root.right)
            
            return left and right
            
        
        return helper(root)