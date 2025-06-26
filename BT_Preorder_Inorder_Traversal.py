# Time Complexity : O(n), where n is the number of nodes (each node is visited once)
# Space Complexity : O(n), due to recursion stack and hashmap storage
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # I use a hashmap to store the indices of inorder elements for O(1) lookup
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        self.pre_idx = 0  # Pointer for current root in preorder list

        def helper(left, right):
            if left > right:
                return None

            # Select the current root from preorder
            root_val = preorder[self.pre_idx]
            self.pre_idx += 1
            root = TreeNode(root_val)

            # Build left and right subtrees using inorder indices
            index = inorder_index_map[root_val]
            root.left = helper(left, index - 1)
            root.right = helper(index + 1, right)

            return root

        return helper(0, len(inorder) - 1)
