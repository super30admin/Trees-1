# Time complexity : O(n)
# Space complexity : O(1) 
# leetcode : solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # call the helper function with the root element having min as -inf and max as inf
        return self.inorder(root, -math.inf, math.inf)
    
    def inorder(self, root, min_val, max_val):
        # checking if root is null, then tree is a valid BST
        if root is None:
            return True
        
        # for every root node or node, we have a local max or min value range, if the root value invalidates that, then tree is not BST
        if root.val >= max_val:
            return False
        if root.val <= min_val:
            return False
        
        # recursivley call the inorder function for left and right subtree, all nodes
        return self.inorder(root.left, min_val, root.val) and self.inorder(root.right, root.val, max_val)
