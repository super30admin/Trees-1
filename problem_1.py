# Time O(n) node of the tree
# Space O(h) = height of tree



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return self.inorder(root, None, None)
    
    def inorder(self, root, max_val, min_val):
        # Base case
        if root is None:
            return True 
        
      
        # check prev
        if (max_val is not None and root.val >= max_val) or (min_val is not None and root.val <= min_val):
            return False 
        # update prev
        return self.inorder(root.right, max_val, root.val) and self.inorder(root.left, root.val, min_val)
        

        