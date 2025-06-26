# Time Complexity :
- O(n), where n is the number of nodes in the tree (each node is visited once)

# Space Complexity :
- O(h), where h is the height of the tree (due to recursion stack)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node, lower=float('-inf'), upper=float('inf')):
            if not node:
                return True

            if not (lower < node.val < upper):
                return False

            return (helper(node.left, lower, node.val) and
                    helper(node.right, node.val, upper))

        return helper(root)
