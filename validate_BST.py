# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag=True
    prev=None

    def helper(self,root):
        if root==None:
            return 

        if self.flag:
            self.helper(root.left)

        if self.prev!=None and self.prev>=root.val:
            self.flag=False
            return
        
        print(root.val)
        self.prev=root.val

        if self.flag:
            self.helper(root.right)


    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

        