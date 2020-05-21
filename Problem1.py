
class Solution:
    def __init__(self):
        self.prev=None
    def isValidBST(self, root: TreeNode) -> bool:
        return self.inorder(root)
    def inorder(self,root)->bool:
        if root is None:
            return True
        if self.inorder(root.left) is False:
            return False
        if self.prev is not None and self.prev.val>=root.val:
            return False
        self.prev=root

        return self.inorder(root.right)