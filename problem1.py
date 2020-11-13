#timecomplexity : can you help to find the complexity of this code for iterative and recursion both
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev=None
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root)
    
    def helper(self,root):
       
        if root == None: return True
        if (self.helper(root.left)==False): return False # y do we need this condition             
        if self.prev!=None and self.prev.val>=root.val: return False
        self.prev=root
        return self.helper(root.right)
       
        