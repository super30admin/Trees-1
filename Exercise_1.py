# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack=[]
        prev=-math.inf
        while root or stack:
            while root:
                stack.append(root)
                root=root.left
            root=stack.pop()
            if root.val<=prev:
                return False
            prev=root.val
            root=root.right
        return True
        