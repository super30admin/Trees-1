# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english:
                - Do an inorder traversal
                - If the last element in the stack is greater than the current element
                  not a valid BST
        """
        # in order traversal LDR
        cur = root
        stack = []
        result = []
        while cur or stack:
            # if we have a left child
            if cur:
                stack.append(cur)
                cur = cur.left
            else:
                # pop data
                cur = stack.pop()
                if result and result[-1] >= cur.val:
                    return False
                result.append(cur.val)
                cur = cur.right
        return True
