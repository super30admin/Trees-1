# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def validate_tree(node,left,right):
            if node is None:
                return True
            if not (node.val > left and node.val < right):
                return False

            return (validate_tree(node.left,left,node.val) and validate_tree(node.right,node.val,right))

        res = validate_tree(root,float("-inf"),float("inf"))
        return res
        