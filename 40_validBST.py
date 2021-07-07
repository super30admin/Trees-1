# S30 Big N Problem #40 {Medium}

# Valid BST

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(n) n= no. of elements in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# The inorder traversal of a valid BST is in ascending order
# Traverse the tree inorder and store the results in an array.
# if the array is ascending, then it is a valid BST

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        res=[]
        self.helper(root,res)
        
        for i in range(len(res)-1):
            
            if res[i]>=res[i+1]:
                return False
            
        return True
            
            
        
        
    def helper(self,root,res):
        
        if root is None:
            return 
        
        self.helper(root.left,res)
        res.append(root.val)
        self.helper(root.right,res)
        
        return res
        
        
        
        
        