"""98. Validate Binary Search Tree
Time Complexity: O(n)
Space Complexity: O(n)
"""
#iterative rescusrsive stack 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def isValidBST(self, root: TreeNode) -> bool:
        
        def inorder(root):
            if not root:
                return True
            if inorder(root.left)==False:
                return False
            if root.val <= self.prev:
                return False
            self.prev = root.val
            return inorder(root.right)
            
            
        self. prev = -float('inf')
        return inorder(root)
        
        
        """stack, prev = [],float('-inf')
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev!=None and root.val<=prev:
                return False
            prev = root.val
            root = root.right
        return True"""