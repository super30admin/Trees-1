# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        ## T.C = O(n)
        ## S.C = O(h) h=> height
        
        stack = []
        prev = None
        
        while root or stack:
            while root:  
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev and prev.val >= root.val:
                return False

            prev = root
            root = root.right

        return True