# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# TC : O(n)
# SC : O(height(tree))
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        temp = root
    
        def helper(root, minimum, maximum):
            if root: # root not None
                left_res = helper(root.left, minimum, root.val)
                if not(root.val > minimum and root.val < maximum):
                    return False
                right_res = helper(root.right, root.val, maximum)
                return left_res and right_res
            return True
        return helper(temp, float('-inf'), float('inf'))
        