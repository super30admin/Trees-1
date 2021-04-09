# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.pre_index = 0
        self.preorder = preorder
        self.inorder = inorder

        self.map = dict()

        self.rootNode = TreeNode(self.preorder[self.pre_index])
        self.pre_index += 1

        for i, val in enumerate(inorder):
            self.map[val] = i

        index = self.map[self.rootNode.val]

        self.rootNode.left = self.build(0, index - 1)
        self.rootNode.right = self.build(index + 1, len(inorder) - 1)

        return self.rootNode

    def build(self, start, end):
        if end < start:
            return None

        root = TreeNode(self.preorder[self.pre_index])
        self.pre_index += 1

        index = self.map[root.val]

        root.left = self.build(start, index - 1)
        root.right = self.build(index + 1, end)

        return root
