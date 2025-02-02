# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        if root == None:
            return True

        self.isvalid = True
        self.prev = None
        self.inorder(root)

        return self.isvalid

    def inorder(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return

        self.inorder(root.left)   

        if self.prev != None and self.prev.val >= root.val:
            self.isvalid = False
            return
        self.prev = root
        self.inorder(root.right)    

        