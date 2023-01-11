# Time Complexity: O(N)
# Space Complexity : O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self,preorder: List[int], inorder: List[int]) -> TreeNode:
        if not (preorder and inorder):
            return None
        root=TreeNode(preorder[0])
        root.left=self.buildTree(preorder[1:inorder.index(root.val)+1],inorder[:inorder.index(root.val)])
        root.right=self.buildTree(preorder[inorder.index(root.val)+1:],inorder[inorder.index(root.val)+1:])
        return root
        