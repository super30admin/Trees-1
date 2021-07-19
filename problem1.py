# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = False
    def isValidBST(self, root: TreeNode) -> bool:
        if root == None:
            return True
        self.helper(root, None , None)
        return self.result
    
    def helper(self, root: TreeNode, min_,max_):
        #base
        if root == None:
            return 
        #min, root.val
        self.helper(root.left, min_, root.val)
        if (max_ != None and root.val >= max_) and (min_ != None and root.val <= min_):
            self.result = False
            return
        self.helper(root.right, root.val, max_)
