class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.prev=None
        self.isValid=True
        self.inOrder(root)
        return self.isValid

    def inOrder(self, root: Optional[TreeNode]) -> None:
        if root==None:
            return
        self.inOrder(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            self.isValid=False
            return
        self.prev=root
        self.inOrder(root.right)