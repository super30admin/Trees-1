class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None
        
        while root != None or len(stack) >= 1:
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev != None and root.val <= prev.val:
                return False
            
            prev = root
            root = root.right
        
        return True
            