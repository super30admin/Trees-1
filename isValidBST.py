# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        """
        Use a stack... 
            Do inOrder traversal.. that means every element would be 
            in ascending order
        """
        if not root:
            return True
        stack = []
        inOrder = float('-inf')
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left 
            root = stack.pop() 
            
            if root.val <= inOrder:
                return False 
            inOrder = root.val 
            root = root.right 
        return True
                
        
        