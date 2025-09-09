# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Tc : O(n)  n is the number of the nodes in the tree
# sc : O(h) h is the height of the tree, recurssive stack space 

class Solution(object):
    # glodbal variables to keep track of the prev node and the flag
    flag = True 
    prev = None

    def isValidBST(self, root):
        self.helper(root) 
        return self.flag 

    def helper(self, root):
        # base
        if root is None:
            return
        
        # inorder traversal 
        self.helper(root.left)

        if self.prev is not None and self.prev.val >= root.val: # if the prev node is greater or equal found the breach not a valid bst
            self.flag = False

        self.prev = root

        if self.flag: # this reduces the extra calls on the right traversal if found the breach
            self.helper(root.right)

    