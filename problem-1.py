"""
Problem:
https://leetcode.com/problems/validate-binary-search-tree/

Approach:

1. Kep 2 global variables isValid and prev. prev contains the element which was last visited in the in-order traversal
2. we know that in order traversal of BST will be in ascending order, so we keep chekcing the current element with the prev element
3. if pre element is >= current element then we make the global variable isValid as False and return
4. finally we return the gloabl variable isValid

"""

# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    isValid = True
    def inOrder(self,root):
        if root==None:
            return
        self.inOrder(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            self.isValid=False
            return
        self.prev = root
        self.inOrder(root.right)
     
    def isValidBST(self, root: TreeNode) -> bool:
        if root==None:
            return True    
        self.inOrder(root)
        return self.isValid
           
        