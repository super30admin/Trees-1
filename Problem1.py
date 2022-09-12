# ## Problem 1

# https://leetcode.com/problems/validate-binary-search-tree/

# Given a binary tree, determine if it is a valid binary search tree (BST).

# Assume a BST is defined as follows:

# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.
# Example 1:

#    2

#    / \

#   1   3

# Input: [2,1,3]
# Output: true
# Example 2:

#    5

#    / \

#   1   4

#      / \

#     3   6

# Input: [5,1,4,null,null,3,6]
# Output: false
# Explanation: The root node's value is 5 but its right child's value is 4.

#Solution

class Solution:
    def __init__(self):
        self.arr = [] 
    def inOrder(self,root):
        if root is None:
            return 
        else:
            self.inOrder(root.left)
            self.arr.append(root.val)
            self.inOrder(root.right)
        return self.arr
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        output = self.inOrder(root)
        for i in range(1, len(output)):
            if output[i-1]>= output[i]:
                return False
        return True
    
# // Time Complexity : o(n) where n is the number of nodes in the tree
# // Space Complexity : o(h) (can be log(n) in Balanced BST where h = log(n)) where h is the height of the tree. Worst case = o(n)