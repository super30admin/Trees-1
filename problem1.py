# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We add the inorder values into a hashmap, and we iterate over the pre-order using a global
# index value. and search for pre-order node in the hashmap and append it to the root node
# We update the index and build the tree.

from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.count = 0
        self.pre = preorder
        hash_map = {}
        size = len(inorder)
        for i in range(size):
            hash_map[inorder[i]] = i
        return self.build(hash_map, 0, size - 1)

    def build(self, hash_map: {}, start, end):
        if start > end:
            return None
        cur_val = self.pre[self.count]
        self.count += 1
        cur = TreeNode(cur_val)
        root_index = hash_map[cur_val]
        cur.left = self.build(hash_map, start, root_index - 1)
        cur.right = self.build(hash_map, root_index + 1, end)

        return cur
