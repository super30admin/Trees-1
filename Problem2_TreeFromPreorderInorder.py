'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 105.
# Given two integer arrays preorder and inorder where preorder is the preorder 
# traversal of a binary tree and inorder is the inorder traversal of the same 
# tree, construct and return the binary tree.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of elements in inorder/preorder traversal array 
#       Need to iterate over each element exactly once. Also need to build
#       hashmap so complexity = 2N

#------------------
# Space Complexity: 
#------------------
# O(N): Hashmap auxiliary data structure required to store value and index
#       of inorder traversal for O(1) lookup. Else, time complexity becomes
#       O(N^2) 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  44 ms   (99.75 %ile)
# Space            :  18.2 MB (95.66 %ile)



# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        n = len(preorder)
        # Object-level scope to store current index of preorder traversal
        self.preorder_index = 0
        # Need this to store value:index map so that we can look up the left
        # half and right half of the inorder array. For every element in the
        # preorder traversal, the portion of the inorder array to the LHS of 
        # the same element is the left child
        self.inorder_map = {value:index for index, value in enumerate(inorder)}

        return self.buildTreeHelper(preorder, 0, n-1)
    
    
    def buildTreeHelper(self, preorder: List[int], left: int, right: int):
        # No left elements, so parent was a leaf node
        # Left and right are bounds of the LHS and RHS of the inorder array
        # pertaining to the element selected as the parent in previous call
        if left > right: 
            return None
        # Otherwise
        else:
            # Choose a value from preorder traversal array. This element is the
            # root. The left subtree is stored from LHS bound to index of this 
            # element in inorder traversal-1.
            # Similarly, right subtree is stored from index of this element
            # in inirder traversal + 1 to RHS bound.
            val = preorder[self.preorder_index]
            root = TreeNode(val)
            self.preorder_index += 1
            root.left = self.buildTreeHelper(preorder, \
                                             left, \
                                             self.inorder_map[val]-1)
            
            root.right = self.buildTreeHelper(preorder,\
                                              self.inorder_map[val]+1,\
                                              right)
            return root