# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity : O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes
# Approach 1: we are
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if preorder is None or inorder is None or len(preorder) == 0:
            return None

        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIndex = inorder.index(rootVal)

        inorderLeft = inorder[0:rootIndex]
        inorderRight = inorder[rootIndex + 1:]
        preorderLeft = preorder[1:rootIndex + 1]
        preorderRight = preorder[rootIndex + 1:]

        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)

        return root

# approach 2: In this approach, instad of seraching index in inorder array everytime, we store it in a hashmap.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.idx = 0
        self.map = {}

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if preorder is None or inorder is None or len(preorder) == 0:
            return None

        for idx, val in enumerate(inorder):
            self.map[val] = idx

        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        # base case
        if start > end:
            return None

        # logic
        rootVal = preorder[self.idx]
        self.idx += 1
        print(rootVal)
        root = TreeNode(rootVal)
        rootIndex = self.map[rootVal]
        root.left = self.helper(preorder, start, rootIndex - 1)
        root.right = self.helper(preorder, rootIndex + 1, end)

        return root









