"""
This module defines a TreeNode class and a Solution class to validate whether a given binary tree 
is a valid Binary Search Tree (BST).

A valid BST is defined as:
- The left subtree of a node contains only nodes with values less than the node's value.
- The right subtree of a node contains only nodes with values greater than the node's value.
- Both the left and right subtrees must also be valid binary search trees.

Classes:
--------
TreeNode:
    A class representing a node in the binary tree with a value and optional left and right children.

Solution:
    Contains method `isValidBST` that initiates recursive validation using value bounds.

Methods:
--------
isValidBST(root):
    Checks if the given binary tree is a valid BST.

helper(root, left, right):
    Recursive helper function that checks whether each node’s value falls within valid bounds 
    (`left < node.val < right`) for BST properties.

Approach:
---------
Use DFS traversal, passing valid lower and upper bounds for each node. 
Update the bounds as you recurse through left and right subtrees.

Time Complexity:
----------------
O(N), where N is the number of nodes in the binary tree.

Space Complexity:
-----------------
O(H), where H is the height of the tree due to the recursion stack.
"""

class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.flag = True
    def isValidBST(self, root):
        self.helper(root, float('-inf'), float('inf'))
        return self.flag
    
    def helper(self, root, left, right):
        if root == None:
            return
        if not (left < root.val and root.val < right):
            self.flag = False
        self.helper(root.left, left, root.val)
        self.helper(root.right, root.val, right)

# Example 1: Valid BST
root1 = TreeNode(2)
root1.left = TreeNode(1)
root1.right = TreeNode(3)

sol = Solution()
print("Is root1 a valid BST?", sol.isValidBST(root1))  # True

# Example 2: Invalid BST
root2 = TreeNode(5)
root2.left = TreeNode(1)
root2.right = TreeNode(4)
root2.right.left = TreeNode(3)
root2.right.right = TreeNode(6)

sol = Solution()
print("Is root2 a valid BST?", sol.isValidBST(root2))  # False

