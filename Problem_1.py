# Valid BST

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes with Runtime: 44 ms and Memory Usage: 16.4 MB
# Any problem you faced while coding this : After Class No
# Your code here along with comments explaining your approach :
# Approach
"""
Using Inorder Traversal approach in which traversal is Left->Root->Right
A Stack is maintained if root is not null and stack is not empty than 
push the element to stack and root will be pointing to the left
the elements will be popped if val is less than inorder(negative infinity variable)
and assign root to right.

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []  # Initializing Empty Stack
        inorder=float('-inf') # Initializing negative infinity
        if not root: 
            return True  
        while(stack or root): # Checking for stack or root to be null
            while(root != None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            if(root.val<=inorder):
                return False
            inorder=root.val
            root=root.right
        return True