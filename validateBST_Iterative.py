"""
Intuition: Use a prev pointer to compare its value with the current root.
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(H), H = Height of the tree
#####################################################################
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        stack = []
        prev = None
        while root != None or not len(stack) == 0:
            
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev != None and  prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True
            