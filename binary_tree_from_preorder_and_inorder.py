"""
Problem: Construct Binary Tree from Preorder and Inorder Traversal (No duplicates)
Leetcode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Solution:
    - Use preorder to find root element at first index
    - Use inorder to find left and right elements of root index
Time Complexity: O(N), being used to traverse the preorder list
Space Complexity: O(N), being used to store the inorder list values and index's
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # class variables
    pre_idx = 0
    preorder = []
    inorder = []
    # hashmap to store inorder value and index's
    index_map = {}

    def buildTree(self, preorder, inorder) -> TreeNode:
        self.preorder = preorder
        self.inorder = inorder

        # Add inorder value and index's to index_map
        idx = 0
        for i in range(len(inorder)):
            self.index_map[inorder[i]] = i

        return self.helper(0, len(self.inorder) - 1)

    def helper(self, left, right):
        # Base case
        if left > right:
            return None

        # find the root from preorder list
        root_val = self.preorder[self.pre_idx]
        root = TreeNode(root_val)
        self.pre_idx += 1

        index = self.index_map[root_val]

        # create left subtree
        root.left = self.helper(left, index - 1)

        # create right subtree
        root.right = self.helper(index + 1, right)

        return root