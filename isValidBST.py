# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Idea: The nodes of left subtree should be less than root and nodes of right subtree should be greater than root.
    # Define the left subtree max boundary as root and define the right subtree minimum boundary as root
    
    # Time Complexity: O(n)
    # Auxiliary Space: O(1)
    # Space Complexity: O(n)
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root,float('-Inf'),float('+Inf'))
    
    def helper(self,root,min_val,max_val):
        if root is None:
            return True
        if root.val <= min_val or root.val >= max_val:
            return False
        return self.helper(root.left,min_val,root.val) and self.helper(root.right,root.val,max_val)
        
