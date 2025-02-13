# Time O(n)
# Space O(1)
class Solution:
    flag = True
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag

    def inorder(self, root: Optional[TreeNode]) -> None:
        if self.flag == False or root is None:
            return
        self.inorder(root.left)  
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        # print(root.val)
        self.inorder(root.right)
        
# Time O(n)
# Space O(1)
class Solution:
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)

    def inorder(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        left = self.inorder(root.left)  
        if self.prev is not None and self.prev.val >= root.val:
            return False
        self.prev = root
        # print(root.val)
        return left and self.inorder(root.right)
        