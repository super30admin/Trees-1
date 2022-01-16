'''
TC: O(n)
SC: O(h) - height of tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
                
        def rec(root, alpha, beta):
            if not root:
                return True
            
            if not (root.val < alpha and root.val > beta):
                return False
            
            return rec(root.left, root.val, beta) and rec(root.right, alpha, root.val)
        
        
        alpha = float("INF")
        beta = float("-INF")
        
        return rec(root, alpha, beta)
        
        
        