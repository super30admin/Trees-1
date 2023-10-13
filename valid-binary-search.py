# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def valid(node, left, right):
            if not node:
                return True
            if not (left < node.val < right):
                return False

            return valid(node.left, left, node.val) and valid(
                node.right, node.val, right
            )

        return valid(root, float("-inf"), float("inf"))
