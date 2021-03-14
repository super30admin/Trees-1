'''
Time Complexity: O(n)
Space Complexity: O(n) Height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        if preorder == None or len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        index = -1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
                break

        root.left = self.buildTree(preorder[1:index + 1], inorder[0:index])
        root.right = self.buildTree(preorder[index + 1:], inorder[index + 1:])
        return root
