# TC:  O(n)
# SC:O(height of the BST)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def inorder(root):
            
            if not root:
                return True
            
            if not (inorder(root.left)):
                return False
            cur_val=root.val
            if self.prev>=cur_val:
                return False
            self.prev=cur_val
            return inorder(root.right)
        
        
        
        
        
        self.prev=float("-inf")
        return inorder(root)