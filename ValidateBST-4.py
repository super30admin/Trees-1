# Recursive Solution - Range check 
# Time Complexity : O(n) where n is the number of nodes in the tree. 
# Space Complexity : O(h) where h is the height of the tree. 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: TreeNode) -> bool: 

        def inorder(root, min_, max_):

            if not root: 
                return True 

            if max_ != None and root.val >= max_:
                return False 
            if min_ != None and root.val <= min_:
                return False 

            return inorder(root.left, min_, root.val) and inorder(root.right, root.val, max_)


        return inorder(root, None, None)