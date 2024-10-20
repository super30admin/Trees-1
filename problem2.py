# time complexity: O(n^2)
# space complexity: O(n^2)

# Approach: Iterate through the preorder and inorder lists and construct the binary tree.
# For each node, find its index in the inorder list and use it to split the left and right subtrees.
# Recursively construct the left and right subtrees.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None

        # Preorder: Root -> Left -> Right
        # Inorder:  Left -> Root -> Right
        root_val = preorder[0]
        root = TreeNode(root_val)

        # Find index of root in inorder to split left and right subtrees
        idx = inorder.index(root_val)

        # Recursively construct left and right subtrees
        root.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
        root.right = self.buildTree(preorder[idx+1:], inorder[idx+1:])

        return root
    
