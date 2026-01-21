# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        self.preorder_index = 0

        # build a hashmap to store index and value for inorder list
        inorder_index_map = {}
        for index, value in enumerate(inorder):
            inorder_index_map[value] = index

        return self.helper(0, len(preorder) - 1, preorder, inorder_index_map)
    
    def helper(self, left, right, preorder, inorder_index_map):
        if left > right:
            return None

        # select the preorder_index element as the root and increment it
        root_value = preorder[self.preorder_index]
        root = TreeNode(root_value)
        self.preorder_index+=1
        
        # build left and right subtree
        root.left = self.helper(left, inorder_index_map[root_value] - 1, preorder, inorder_index_map)
        root.right = self.helper(inorder_index_map[root_value] + 1, right, preorder, inorder_index_map)

        return root