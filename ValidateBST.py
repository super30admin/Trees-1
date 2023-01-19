#Time Complexity: O(N)
#Space Complexity: O(h) height of the tree
#Successfulyy ran on leetcode

class Solution:
    def __init__(self):
        self.isValid = True
        self.prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)
    def inorder(self,root):
        if not root:
            return
        self.inorder(root.left)
        if self.prev and self.prev.val>=root.val:
            self.isValid = False
            return self.isValid
        self.prev = root
        self.inorder(root.right)
        return self.isValid