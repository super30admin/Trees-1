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
        
        ### Iterative Version
        while root or stack:
            
            # Push all left children
            while root:
                stack.append(root)
                root = root.left
            
            # Process Node
            root = stack.pop()
            
            # Validate Order and Update Previous
            if prev and prev.val >= root.val:
                return False    
            prev = root
            
            # Process Right Tree
            root = root.right
            
        return True

### Complexity Analysis:

# Time Complexity: O(N) --> N = number of nodes
# Space Complexity: O(H) --> H = height of tree occupied by stack