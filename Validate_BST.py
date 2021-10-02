# Validate_BST
# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev = None
        result = True
        
        def helper(root):
            nonlocal result
            nonlocal prev
            if root == None:
                return 
            helper(root.left)
            
            if prev and root and prev.val >= root.val:
                result = False
                return result
            
            prev = root
            helper(root.right)
        
        helper(root)
        return result