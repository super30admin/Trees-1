'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 98.
# Given the root of a binary tree, determine if it is a valid binary search tree 
# (BST).

# A valid BST is defined as follows:

# The left subtree of a node contains only nodes with keys less than the node's 
# key.
# The right subtree of a node contains only nodes with keys greater than the node's
# key.
# Both the left and right subtrees must also be binary search trees.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of nodes in the tree. 
#       Need to iterate over each node exactly once

#------------------
# Space Complexity: 
#------------------
# O(H): Require iterative stack with max size = height of BST. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  460 ms (5.17 %ile)
# Space            :  17.9 MB (6.26 %ile)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import math
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # Push Node, lowerbound and upperbound as tuple onto stack.
        # Use this stack to iteratively traverse nodes of the tree
        if root is None:
            return True

        else:
            dfs_stack = [[root, -math.inf, math.inf]]

            while len(dfs_stack) > 0:
                visited_node, low, high = dfs_stack.pop()
                if visited_node is not None:
                    if (visited_node.val <= low or visited_node.val >= high):
                        print(f"visited_node:{visited_node}, low:{low}, high:{high}")
                        return False

                    dfs_stack.append([visited_node.right, visited_node.val, high ])

                    dfs_stack.append([visited_node.left, low, visited_node.val])

            return True

            