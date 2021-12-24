#Time Complexity : O(n) - Visit each tree node
#Space Complexity : O(n) - Space for the stack


def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        prev = None
        
        stack = deque()
        
        while(stack or root != None):
            while(root != None):
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            if (prev != None and prev.val >= root.val):
                return False
            
            prev = root
            root = root.right
            
        return True
            
        
