"""

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


"""

# Time Complexity : O(n) n = nodes in the tree
# Space Complexity : O(h) h = height of the tree
# Did this code successfully run on leetCode : Yes
# Any problem you faced while coding this :  No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global prev
        prev = None
    
        def inOrder(root):
            global prev

            if root is None: 
                return True

            if inOrder(root.left) is False:
                return False

            if prev is not None and prev.val >= root.val:
                return False

            prev = root
            return inOrder(root.right)
    
        return inOrder(root)
       
    """
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        st = []
        prev = None
        #inorder(root.left)
        while (root != None or len(st) != 0):
            while(root != None):
                st.append(root)
                root = root.left
            root = st.pop()
            if (prev != None and prev.val >= root.val):
                return False
            
            prev = root
            root = root.right
            
        return True
    """
        