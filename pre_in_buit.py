# Time Complexity:O(n) (where n = number of nodes)
# Space Complexity:O(n) (where n = number of nodes)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach: Store the inorder in a HashMap and keep an index to iterate the preorder sequence
# Use the inorder hash map to find the index of root.
# recursively run -> [Start: root_idx-1] is the left subtree and [root_idx+1: End] is the right subtree.

class Solution:
    def __init__(self):
        self.inorder_map = {}
        self.root_idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        for idx, node_val in enumerate(inorder):
            self.inorder_map[node_val] = idx

        return self.helper(preorder,0, len(inorder) - 1)

    def helper(self, preorder,start, end):
        if start > end:
            return None

        root_val = preorder[self.root_idx]
        root = TreeNode(root_val)

        self.root_idx += 1

        inorder_idx = self.inorder_map[root_val]

        root.left = self.helper(preorder,start, inorder_idx - 1)
        root.right = self.helper(preorder,inorder_idx + 1, end)

        return root