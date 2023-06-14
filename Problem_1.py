"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(log(n)) or O(H) - height of the tree/height of the recursive stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Initializing the flag to True, Traversing the tree using Inorder traversal
If any node encountered which does not satisfy the property of BST ,updating the flag to False
Returning the False at the end, if no such element found, returning the original value of flag
"""

# Approach - 1

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):

        self.prev=None
        self.flag=None

    def isValidBST(self, root):

        self.flag=True
        self.inorder(root)
        return self.flag

    def inorder(self,root):

        if root==None or self.flag==False:
            return
        print(root.val)
        self.inorder(root.left)
        
        if self.prev!=None and self.prev.val>=root.val:
            self.flag=False
        self.prev=root
        self.inorder(root.right)

# Approach - 2

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def __init__(self):
        self.flag=True

    def isValidBST(self, root):
        self.helper(root,None,None)
        return self.flag

    def helper(self,root,low,high):
        if self.flag==True:
            if root==None:
                return
            print(root.val)
            if (low!=None and root.val<=low) or (high!=None and root.val>=high):
                self.flag=False

            self.helper(root.left,low,root.val)
            self.helper(root.right,root.val,high)
