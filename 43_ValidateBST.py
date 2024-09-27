# passed on leetcode - 98
# time - O(N), space - O(1) or recurrsion stack.
# solution: 1. maintain max and min at every point, 2. If moving towards left update maximum value.
# 3. If moving towards right update minimum value.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, None, None)
    def helper(self, root, min, max):
        # Base case
        if not root: return True
        if min != None and root.val <= min: return False
        if max != None and root.val >= max: return False
        return self.helper(root.left,min,root.val) and self.helper(root.right,root.val,max)

# sol = Solution()
# print(sol.isValidBST([2,1,3]))