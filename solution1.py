# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    flag = True
    prev = TreeNode(None,None,None)
    def isValidBST(self, root):
        flag = True
        self.helper(root)
        return self.flag
        
    def helper(self, root):
        if root == None:
            return
        self.helper(root.left)
        if self.prev and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        print(root.val)
        # if left:
        self.helper(root.right)
        