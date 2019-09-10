  
# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(n) (If we consider constructed tree )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Select root as first element from preorder list and pop it.
# - From that element in inorder, everything left constructs left side of tree and everything right constructs right side of tree.
# - Repeat this till end of tree is reached

# Your code here along with comments explaining your approach
#     Took hint from discussions for this question as found no way to do it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
#       If we have empty list than return None because we reached the end of tree.
        if not preorder:
            return None
        if not inorder:
            return None
#       Take current element as first element from the preorder list and remove it from the list.
        current = preorder.pop(0)
#       Create tree node with the current element
        root = TreeNode(current)
#       find index of current element from inorder list because we will use it to divide left and right tree.
        index = inorder.index(current)
        
#       Create left side of the tree with preorder(first element already removed from this list) list and slice inorder list from first element to element before current indexed element.
        root.left = self.buildTree(preorder, inorder[:index])
#       Create right side of the tree with preorder(first element already removed from this list) list and slice inorder list from element after current indexed element to last element.
        root.right = self.buildTree(preorder, inorder[index+1:])
        
#       return root of the tree
        return root
