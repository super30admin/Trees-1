# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I do inorder traversal comparing whenever I reach node to see if it is greater than the previous root value
# Your code here along with comments explaining your approach

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None
        def helper(current):
            #Terminating condition
            if(not current):
                return True
            #Operations
            
            left_result  = helper(current.left)
            if not left_result: return False
            
            if self.prev is not None and (self.prev >= current.val):
                return False
            
            self.prev = current.val
                
            return True and helper(current.right)
        
        return helper(root)