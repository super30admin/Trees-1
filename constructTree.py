# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Use preorder to pick root nodes sequentially (root -> left -> right).
# Use a hashmap to store (value : index) for inorder traversal for O(1) lookup.
# Maintain a pointer (pre_idx) to track current root in preorder.
# For each root, find its index in inorder to divide into left and right subtrees.
# Recursively build left subtree first, then right subtree using inorder boundaries.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index = {val: i for i, val in enumerate(inorder)}
        pre_idx = 0

        def helper(left, right):
            nonlocal pre_idx

            if left > right:
                return None

            root_val = preorder[pre_idx]
            pre_idx += 1

            root = TreeNode(root_val)
            mid = inorder_index[root_val]

            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)

            return root

        return helper(0, len(inorder) - 1)