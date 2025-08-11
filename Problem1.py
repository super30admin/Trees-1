class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.valid = True
        self.prev = None
        self.inorder(root)
        return self.valid

    def inorder(self, root):
        if root == None:
            return
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            self.valid = False
            return
        self.prev = root
        self.inorder(root.right)
        return
        

