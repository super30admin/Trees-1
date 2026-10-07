# Definition for a binary tree node.
# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Iterative Approach and inorder traversal. Push the nodes into stack and if visited pop it into the res array
# If not visited check the left and right child of that node and push it to stack
# Once all the nodes are processed, the output will be a sorted array for BST
# If it is not a sorted array then it is not a valid BST


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode | None) -> bool:
        if root is None:
            return False
        def inorder(root):
            stack = [(root, False)]
            res = []
            while stack:
                node, visited = stack.pop()
                if node:
                    if visited:
                        res.append((node.val))
                    else:
                        stack.append((node.right, False))
                        stack.append((node, True))
                        stack.append((node.left, False))
            return res
        output = inorder(root)
        for i in range(1, len(output)):
            if output[i-1] >= output[i]:
                return False
        return True
#Time - O(N) where n is the number of nodes
#Space - O(H) where h is the height of the tree

#Recursion
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: TreeNode | None) -> bool:
        self.helper(root)
        return self.flag

    def helper(self, root):
        if root is None:
            return

        if self.flag:
            self.helper(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        self.prev = root

        if self.flag:
            self.helper(root.right)
#Time - O(N) where n is the number of nodes
#Space - O(H) where h is the height of the tree

class Solution:
    def isValidBST(self, root: TreeNode | None) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, min_val, max_val):
        if root is None:
            return True
        if min_val is not None and root.val <= min_val:
            return False
        left = self.helper(root.left, min_val, root.val)
        if max_val is not None and root.val >= max_val:
            return False
        right = self.helper(root.right, root.val, max_val)
        return left and right
