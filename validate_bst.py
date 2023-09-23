"""
Maintain a lower and upper bound and check each node if thery lie within the bound.
If we move to te righ update lower bound . if we move to the right update upper bound

Time complexity - O(n)
Space complexity -O(n) - stack else O(1)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self,root,lower,upper):
        if root == None :
            return True
        if (root.val >= upper) or (root.val <=lower) :
            return False
        
        return self.helper(root.left, lower, root.val) and self.helper(root.right, root.val,upper)
    
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, float("-Inf"),float("Inf"))
