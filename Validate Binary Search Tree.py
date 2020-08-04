# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(d) depth of the tree to store in recursive stack
# # Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(d) depth of the tree to store in  stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#We recursively traverse the tree towards the left and check if left < root < right

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def isValidBST(self, root: TreeNode) -> bool:

        def inOrder(root, lower=float('-inf'), higher=float('inf')):

            if not root:
                return True

            val = root.val

            if val <= lower or val >= higher:
                return False

            if not inOrder(root.right, val, higher):
                return False

            if not inOrder(root.left, lower, val):
                return False

            return True

        return inOrder(root)

    # Iterative solution
    def isValidBSTIterative(self, root: TreeNode) -> bool:

        stack = []
        prev = float('-inf')

        while stack or root:

            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            if root.val <= prev:
                return False
            prev = root.val
            root = root.right

        return True




