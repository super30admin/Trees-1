"""
## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

"""

# Approach - 1  Boolean non conditional 
# TC for all: O(n) no of nodes in a tree
# SC for all: O(H) height of a tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
       
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
        
        left = self.isValidBST(root.left)
        if (self.prev != None and self.prev >= root.val):
            return False
        
        self.prev = root.val
        
        right = self.isValidBST(root.right)
        
        return (left and right)


# Approach - 2: void based conditional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None
        
    def inorder(self, root):
        #base
        if (root == None) : return
        
        self.inorder(root.left)
        #print("up", " ", root.val)
        if (self.prev != None and self.prev >= root.val):
            self.flag = False
            
        self.prev = root.val  
        if self.flag:   
            self.inorder(root.right)
            #print("down", " ", root.val)
            
        
            
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.inorder(root)
        return self.flag

# Approach - 3 using max and min and conditional recursion

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
    
    def inorder(self, root, min_, max_  ):
        # Base
        if root == None: return 
        
        #Logic
        if (min_ != None and min_ >= root.val):
            self.flag = False
        
        if (max_ != None and max_ <= root.val):
            self.flag = False
       
        self.inorder(root.left, min_, root.val)
        if(self.flag):
            self.inorder(root.right, root.val, max_)
        
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root, None, None)
        return self.flag
        
        
        
        
# Approach - 4 boolean based recursion

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def inorder(self, root, min_, max_  ):
        # Base
        if root == None: return True
        
        #Logic
        if (min_ != None and min_ >= root.val):
            return False
        
        if (max_ != None and max_ <= root.val):
            return False
       
        return  self.inorder(root.left, min_, root.val) and self.inorder(root.right, root.val, max_)
        
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        return self.inorder(root, None, None)
        
        
        
        