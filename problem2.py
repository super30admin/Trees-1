# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english :
# 1. The first element in preorder is always the root of the tree/subtree.
# 2. Use a hashmap to find the root’s index in inorder in O(1) time to split left and right parts.
# 3. Recursively build left and right subtrees using these index boundaries.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.idx = 0  # pointer for current root position in preorder list
        inorder_map = {val: i for i, val in enumerate(inorder)}  # map node value -> inorder index
        return self.helper(preorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, preorder, start, end, inorder_map):
        # Base case: no elements left in this inorder range
        if start > end:
            return None

        # The next element in preorder is the current root
        root_val = preorder[self.idx]
        self.idx += 1  # move pointer to next root for upcoming recursive calls

        # Create the TreeNode with this value
        root = TreeNode(root_val)

        # (Optional) store the inorder index inside the node for reference/debugging
        root.idx = inorder_map[root_val]

        # Recursively build left subtree from elements before root in inorder
        root.left = self.helper(preorder, start, root.idx - 1, inorder_map)

        # Recursively build right subtree from elements after root in inorder
        root.right = self.helper(preorder, root.idx + 1, end, inorder_map)

        # Return the constructed node to parent call
        return root
