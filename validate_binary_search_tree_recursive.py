"""
Problem: Validate Binary Search Tree
Leetcode: https://leetcode.com/problems/validate-binary-search-tree/
Solution: Recursive approach
Time Complexity: O(N), since we visit each node
Space Complexity: O(N), since we store entire tree
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BST:
    def isValidBST(self, root):
        return self.helper(root)

    def helper(self, node, lower=float('-inf'), upper=float('inf')):

        # Base case
        if not node:
            return True

        # check each incoming node if it satisfies BST rules
        value = node.val
        # if boundary does not exist on left side, no need to call function recursively
        if not lower and lower >= value:
            return False

        # if boundary does not exist on right side, no need to call function recursively
        if not upper and upper <= value:
            return False

        # check left and right node for BST rules
        return self.helper(node.left, lower, value) and self.helper(node.right, value, upper)


obj = BST()
root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)
print(obj.isValidBST(root))
# print(obj.isValidBST([5,1,4,None,None,3,6]))