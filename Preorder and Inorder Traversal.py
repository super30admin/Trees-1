# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#we recursively find root from preorder each time and get the left and right element from the inorder

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode:

        if len(preorder) == 0:
            return

        root = TreeNode(preorder[0])

        rootindx = -1

        for index, val in enumerate(inorder):

            if root.val == val:
                rootindx = index

        inleft = inorder[:rootindx]

        preleft = preorder[1:rootindx + 1]

        inright = inorder[rootindx + 1:]

        preright = preorder[rootindx + 1:]

        root.left = self.buildTree(preleft, inleft)

        root.right = self.buildTree(preright, inright)

        return root