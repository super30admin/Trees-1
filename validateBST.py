"Time Complexity is O(N)"
"Space Complexity is O(H) - H is height of the tree"

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = [None] 
        
        def helper(node):
            if not node: 
                return True
            
            if not helper(node.left):
                return False
            
            if prev[0] and prev[0].val >= node.val:
                return False
            
            prev[0] = node
            
            return helper(node.right)
        
        return helper(root)