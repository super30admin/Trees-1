# passed on leetcode (105)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder, inorder) -> TreeNode:
        # edge case

        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        index = -1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                index = i
                break

        preLeft = preorder[1:index + 1]
        preRight = preorder[index + 1:len(preorder)]
        inLeft = inorder[0:index]
        inRight = inorder[index + 1:len(inorder)]

        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root
