# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        inorder = []
        inorder.append(float("-inf"))
        def dfs(root):
            if root == None:
                return True
            dfs_left = dfs(root.left)
            if (inorder[-1]>= root.val):
                return False
            inorder.append(root.val)
            dfs_right = dfs(root.right)
            return dfs_left and dfs_right

        return dfs(root)