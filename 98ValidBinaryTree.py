class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node,lower,upper):
            if not node:
                return True
            val = node.val
            if val <= lower or val >= upper:
                return False 
            return helper(node.left, lower, val) and helper(node.right, val, upper)  
        return helper(root, float("-inf"),float("inf"))
