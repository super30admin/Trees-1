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
# O(H): Require recursive stack with max size = height of BST. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  44 ms (71.17 %ile)
# Space            :  16.4 MB (52.73 %ile)

import math
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.check_node(root)


    def check_node(self, node:TreeNode, low = -math.inf: int, high = math.inf :int) -> bool:
        if node is None:
            return True
        else:
            if node.val <= low or node.val >= high:
                return False

            return ((check_node(node.left, low, node.val) and \
                check_node(node.right, node.val, high))
