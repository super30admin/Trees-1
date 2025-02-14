# Approach:
# We use a recursive helper function validate(node, low, high) to check if each node's value is within a valid range
#  (low < node.val < high). The left subtree must have values < node.val, and the right subtree must have values > node.val.
# node is visited once).
# Space Complexity: O(h) (Recursive stack depth, where h is the tree height; worst case O(n) for skewed trees, 
# (logn) for balanced trees).
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def validate(node, low, high):
            if not node:
                return True
            if node.val <= low or  node.val >= high:
                return False
            return validate(node.left, low, node.val) and validate(node.right, node.val, high)

        return validate(root, -math.inf, math.inf)