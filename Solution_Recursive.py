"""
Time complexity O(N)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_Recursive:
    def isValidBST(self, root: TreeNode) -> bool:
        global prev
        prev= None
        
        return self.inorder(root)
    
    def inorder(self, root):
        
        global prev 
        
        if root is None:
            return True
        
        if self.inorder(root.left) == False:
            return False
        
        if(prev and prev.val>= root.val):
            return False
        
        prev=root
        return self.inorder(root.right)
    
        