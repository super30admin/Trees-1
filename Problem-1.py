class Solution:

    def __init__(self):
        prev = TreeNode()

    def isValidBST(self, root: TreeNode) -> bool:

        self.prev=None
        return self.bst(root)

    def bst(self,root):

            if root is None:
                return True
            if self.bst(root.left) == False:
                return False
            if (self.prev != None and self.prev.val>=root.val): return False
            self.prev=root
            return  self.bst(root.right)
