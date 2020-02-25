'''
Time Complexity: O(n^2)
Space Complexity: O(nlogn)
Did this code successfully run on Leetcode : Yes
Explanation: Preorder always contains the root node at 0 position, we find the equivalent left subtree and right by
finding the position of the root in the inorder Array. Keep doing this until we are left with only 1 element and add
that to the root.left and right and create the tree from bottom to top.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or len(inorder) == 0:
            return None

        # Step1: find root
        # pre: root L R
        # inorder:L root R

        rootValue = preorder[0]
        rootIndex = 0

        for i in range(0, len(inorder)):
            if rootValue == inorder[i]:
                rootIndex = i
                break

        root = TreeNode(rootValue)

        inorderLeft = inorder[0:rootIndex]
        inorderRight = inorder[rootIndex + 1: len(inorder)]

        preorderLeft = preorder[1:len(inorderLeft) + 1]
        preorderRight = preorder[len(inorderLeft) + 1:len(preorder)]

        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)

        return root