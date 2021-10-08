# Time complexity: O(n) n=len(inorder)
# Space complexity: O(n)


class TreeNode:
    def __init__(self, value, left=None, right=None):
        self.val = value
        self.left = left
        self.right = right


class Solution:
    def constructBinaryTree(inorder, preorder):
        if len(inorder) != len(preorder):
            return None
        preorder = preorder[::-1]
        return self.btHelper(inorder, preorder)

    def btHelper(self, inorder, preorder):
        if len(inorder) == 0 or len(preorder) == 0:
            return None

        value = preorder.pop()
        inorderIndex = inorder.index(value)
        root = TreeNode(value)
        root.left = self.btHelper(inorder[:inorderIndex], preorder)
        root.right = self.btHelper(inorder[inorderIndex+1:], preorder)
        return root
