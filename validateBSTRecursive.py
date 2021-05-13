# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    def isValidBST(self, root: TreeNode) -> bool:
        
        return self.inorder(root)
    
    def inorder(self, root : TreeNode ) -> bool:
        if root is None:
            return True
        
        
        if self.inorder(root.left) == False:
            return False
        
        if self.prev is not None and self.prev.val>=root.val:
            return False
        
        self.prev = root
    
        return self.inorder(root.right)
    
#  this is recursive solution -> o(n) is the time complexity  and o(h) is the space complexity which is height of tree..    
