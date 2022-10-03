# TC: O(n)
# SC: O(h) - height of the tree
class Solution:
    def __init__(self):
        self.prev = None
        self.isValid = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return False
        self.dfs(root)

        return self.isValid

    def dfs(self, root):
        if root == None:
            return

        self.dfs(root.left)
        if self.prev and self.prev.val >= root.val:
            self.isValid = False
            return
        self.prev = root
        
        self.dfs(root.right)
