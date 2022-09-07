# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def inorder(root,mini,maxi):
            if root==None:
                return True
            
            if mini!=None and root.val<=mini:
                return False
            
            if maxi!= None and root.val>=maxi:
                return False
            
            return inorder(root.left,mini,root.val) and inorder(root.right,root.val,maxi)
        
        return inorder(root,None,None)