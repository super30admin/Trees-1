# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        
        def validBST(root, mini, maxi):
            
            if root is None:
                return True
            if maxi <= root.val or root.val <= mini:
                return False
            
            print(maxi,root.val,mini)
            return validBST(root.left,mini, root.val) and validBST(root.right, root.val, maxi)
            
            
        return validBST(root,float("-inf"),float("inf"))