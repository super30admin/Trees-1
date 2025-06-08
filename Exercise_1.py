# Problem #43 Validate BST
#LeetCode #98 https://leetcode.com/problems/validate-binary-search-tree/description/

# Author : Akaash Trivedi
# Time Complexity : O(h) h -> height of the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

## Void base recursion

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # define global variables in python
    def __init__(self):
        self.prev = None
        self.flag = True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag
    
    def inorder(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return
        
        self.inorder(root.left)
        # st.pop()

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        #print(root.val)
        
        self.prev = root
        self.inorder(root.right)
        # st.pop()

## Conditional void recursion:

class Solution:
    # define global variables in python
    def __init__(self):
        self.prev = None
        self.flag = True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag
    
    def inorder(self, root: Optional[TreeNode]) -> None:
        #conditional base recurssion if flag is false dont go ahead
        if root == None or not self.flag:
            return
        
        self.inorder(root.left)
        #stack.pop()

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        print(root.val)
        
        self.prev = root
        # condition base recurssion
        if self.flag:
            self.inorder(root.right) 
            #stack.pop()


## boolean base recursion

class Solution:
    # define global variables in python
    def __init__(self):
        self.prev = None
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)

    def inorder(self, root: Optional[TreeNode]) -> bool:
        #conditional base recurssion if flag is false dont go ahead
        if root == None:
            return True
        
        left = self.inorder(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            return False
        #print(root.val)
        
        self.prev = root
        right = self.inorder(root.right)
        return left and right