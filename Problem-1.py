"""
https://leetcode.com/problems/validate-binary-search-tree/
Approach 1: using a previous pointer
When a node is popped out of the recursive stack call it previous node, before that compare it with the current node.
this would work for both left and right children nodes

TC: O(n)
SC: O(n) considering the stack space
"""
class Solution:
    def __init__(self):
        self.prev = None
        self.result = True

    def isValidBST(self, root: TreeNode) -> bool:
        self.helper(root)
        return self.result

    def helper(self, root):
        if not root: return
        # self.prev = root
        self.helper(root.left)
        if self.prev and self.prev.val >= root.val: self.result = False
        self.prev = root
        self.helper(root.right)

"""
Approach 2: Iterative way with same approach

TC: O(n)
SC: O(n)
"""

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = deque()
        result = True
        prev = None
        while root or stack:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()

            if prev and prev.val >= root.val:
                result = False
            prev = root
            root = root.right

        return result