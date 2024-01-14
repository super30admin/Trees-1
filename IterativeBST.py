# Trees-1

## Problem 1


#Validate BST using Recursion
# Time Complexity = O(n)
# Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):

        BST = []
        prevElement = None

       # if BST is not empty and root is not null 
        while BST or root:
            while root:
                BST.append(root)
                root = root.left

            # pop the root element
            root = BST.pop()
            if(not prevElement and prevElement.val >= root.val):
                return False
            
            prevElement = root
            root = root.right

        return True







            