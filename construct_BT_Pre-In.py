#TC = O(n*n)
#SC = O(n)
#Compiled and run on LC

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if (len(preorder) == 0):
            return None

        root_val = preorder[0]

        root = TreeNode(root_val)

        root_idx = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:root_idx + 1], inorder[:root_idx])
        root.right = self.buildTree(preorder[root_idx + 1:], inorder[root_idx + 1:])

        return root
