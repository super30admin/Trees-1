# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        self.isValid = True
        self.prev = -sys.maxsize

        self.validate(root)

        return self.isValid

    def validate(self, root):
        if root == None:
            return

        self.validate(root.left)

        if root.val <= self.prev:
            self.isValid = False
            return

        self.prev = root.val

        self.validate(root.right)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        self.prev = -sys.maxsize

        self.stack = list()

        while root != None or self.stack:

            while root != None:
                self.stack.append(root)
                root = root.left

            node = self.stack.pop(-1)

            if node.val <= self.prev:
                return False

            self.prev = node.val
            root = node.right

        return True
