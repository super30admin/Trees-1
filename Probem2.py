# Problem 2 : 
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''
# Iterative solution
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # base case check if preorder and inorder is empty
        if not preorder or not inorder:
            return None

        # stack use to keep track of working nodes
        stack = []
        # first element of the preorder is the root of the tree
        root = TreeNode(preorder[0])
        # appending the root to th stack
        stack.append(root)
        # index of the in-order traversal list
        inorderIndex = 0

        # traversing the pre-order list
        for i in range(1, len(preorder)):
            currentNode = stack[-1]
            newNode = TreeNode(preorder[i])

            # checking value of currentNode and inorder[inorderIndex]
            if currentNode.val != inorder[inorderIndex]:
                # if not equal then current node is the left child of the last node
                currentNode.left = newNode
                # add node to stack
                stack.append(newNode)
            else:
                # This means that current_node is the root of the current sub tree
                while stack and stack[-1].val == inorder[inorderIndex]:
                    currentNode = stack.pop()
                    inorderIndex += 1
                # After popping the nodes whose left subtrees are fully processed, assign the new node as the right child of current_node
                currentNode.right = newNode
                stack.append(newNode)
        return root
    





# Recursive solution
from typing import List
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Base Case when there is no node in preorder and inorder list
        if not preorder or not inorder:
            return None
        # The first element in the preorder list is the root
        root = TreeNode(preorder[0])
        # Get the index of the root element in order list. Since all the elements before root are part of left sub tree and element after root are part of right subtree
        midIndex = inorder.index(preorder[0])     
        # Create left sub tree from elements in preorder from 1 to midImdex+1 (midIndex+1 number of elements are in left sub tree), and from elements from 0 to midIndex in inorder list  
        root.left = self.buildTree(preorder[1:midIndex+1], inorder[0:midIndex])
        # Create right sub tree from elements in preorder from midImdex+1 to last element, and from elements from 0 to midIndex +1 (since midIndex is index of the root) in inorder list  
        root.right = self.buildTree(preorder[midIndex+1:], inorder[midIndex+1:]) 
        return root