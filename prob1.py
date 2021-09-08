class TreeNode:
    
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def isValidBST(self, root) -> bool:

        prev = TreeNode(None)
        stack = []

        while root is not None or len(stack) != 0:
            while root is not None:

                stack.append(root)
                root = root.left
            root = stack.pop() 
            if prev.val is not None and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        
        return True
