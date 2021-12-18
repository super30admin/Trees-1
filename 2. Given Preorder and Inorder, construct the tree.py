class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder, inorder):
        # Time Complexity = O(n)
        # Space Complexity = O(1) as we're returning the new tree

        # If any of the arrays are none, then return None
        if not preorder or not inorder:
            return None

        # First element of the preorder is always the root
        root = TreeNode(preorder[0])

        # Find the index of the above root in inorder
        mid = inorder.index(preorder[0])

        # Recursively build left and right sub trees
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return root