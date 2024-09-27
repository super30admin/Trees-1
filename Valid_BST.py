
// Time Complexity :O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach: using recursion and binary search tre rules


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.check_bsf(root, float("-inf"), float("inf"))
        
    def check_bsf(self, node, low, high):
        if not node:
            return 1
        
        if node.val <= low or  node.val >= high:
            return 0
        
        return self.check_bsf(node.left, low, node.val) and self.check_bsf(node.right, node.val, high)
    
