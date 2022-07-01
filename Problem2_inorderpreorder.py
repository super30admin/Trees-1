# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Time Complexity : O(n)
Space Complexity: O(n)
'''


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # checking for the null case
        if not preorder or not inorder:
            return None

        # initializing the preorder cause it is root - left - right
        root = TreeNode(preorder[0])
        # intializing the inorder cause it is left - root - right
        mid = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])

        return root