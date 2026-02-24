# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : elements to the left and right of root in inorder array are used to form the left and right subtree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.preorder_idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def tree(left, right):
            if left > right:
                return None

            root_val = preorder[self.preorder_idx]
            root = TreeNode(root_val)
            self.preorder_idx += 1

            root.left = tree(left, inorder_idx_map[root_val] - 1)
            root.right = tree(inorder_idx_map[root_val] + 1, right)

            return root


        inorder_idx_map = {}

        for idx, val in enumerate(inorder):
            inorder_idx_map[val] = idx

        return tree(0, len(preorder) - 1)
        