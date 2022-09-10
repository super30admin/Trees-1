# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node, lower = float('-inf'), upper = float('inf')):
            if not node:
                return True
            
            val = node.val
            if val <= lower or val >= upper:
                return False

            if not helper(node.right, val, upper): #Compare right sub-tree
                return False
            if not helper(node.left, lower, val): #Compare left sub-tree
                return False
            return True

        return helper(root)