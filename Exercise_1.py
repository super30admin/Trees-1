# # Trees-1

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
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(self, root):
        self.prev = None
        flag = True
        self.inorder(root)
        return flag

    def inorder(self, root):
        # base case
        if (root is None):
            return
        self.inorder(root.left)
        # root = st.pop()
        if (self.prev is not None and self.prev.val >= root.val):
            return False
        print('up', root.val)
        self.prev = root
        self.inorder(root.right)
        # root = st.pop()
        print('down', root.val)


def create_tree(values, index=0):
    if index >= len(values) or values[index] is None:
        return None
    node = TreeNode(values[index])
    node.left = create_tree(values, 2 * index + 1)
    node.right = create_tree(values, 2 * index + 2)
    return node


sol = Solution()
nodes = [80, 70, 100, 60, 75, 90, 110, 50, 65, 72, 77, 85, 95, 105, 115]
root = create_tree(nodes)
print(sol.isValidBST(root))

# Boolen based Recursion
# class Solution:
#     def isValidBST(self, root):
#         self.prev = None
#         return self.inorder(root)

#     def inorder(self, root):
#         # base case
#         if root is None:
#             return True
#         left = self.inorder(root.left)
#         # root = st.pop()
#         if (self.prev is not None and self.prev.val >= root.val):
#             return False
#         self.prev = root
#         right = self.inorder(root.right)
#         # root = st.pop()
#         return left and right

# # class Solution:
# #     def isValidBST(self, root):
# #         self.prev = None
# #         return self.inorder(root)

# #     def inorder(self, root):
# #         # base case
# #         if root is None:
# #             return True
# #         if not self.inorder(root.left):
# #             return False
# #         # root = st.pop()
# #         if (self.prev is not None and self.prev.val >= root.val):
# #             return False
# #         self.prev = root
# #         if not self.inorder(root.right):
# #             return False
# #         # root = st.pop()
# #         return True


# # # Iterative inorder
# # # class Solution:
# # #     def isValidBST(self, root):
# # #         # empty stack
# # #         stack = []
# # #         # prev variable for previous root
# # #         prev = None
# # #         # run till stack is not empty or if the root is None
# # #         while stack or root:
# # #             # till we reach the left most
# # #             while root:
# # #                 # append the elements into the stack
# # #                 stack.append(root)
# # #                 # going to the left
# # #                 root = root.left
# # #             # once end is reached, pop the last element
# # #             root = stack.pop()
# # #             # checking if order is okay
# # #             if (prev is not None and prev.val >= root.val):
# # #                 return False
# # #             prev = root
# # #             # going to right
# # #             root = root.right
# # #         return True


# # # # Recursive Traversal with Valid Range
# # # # class Solution:
# # # #     def isValidBST(self, root):
# # # #         self.flag = True
# # # #         self.helper(root, None, None)
# # # #         return self.flag

# # # #     def helper(self, root, low, high):
# # # #         # base case
# # # #         if root is None:
# # # #             return self.flag
# # # #         if ((low is not None and root.val <= low) or (high is not None and root.val >= high)):
# # # #             self.flag = False
# # # #             return self.flag
# # # #         # Logic
# # # #         if self.flag:
# # # #             self.helper(root.left, low, root.val)
# # # #         if self.flag:
# # # #             self.helper(root.right, root.val, high)
