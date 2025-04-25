
def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        return self.helper(root)

    def helper(self,root):
        #  base
        if not root:
            return True
        # calls
        left = self.helper(root.left)
        #  condition
        if self.prev is not None  and  root.val <= self.prev.val:
            return False
        self.prev = root

        if left:
            right = self.helper(root.right)
    
        return left and right
