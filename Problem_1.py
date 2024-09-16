
# 98. Validate Binary Search Tree

# Code:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        prev = None
        
        stk = []
        
        #Approach:  Do an inorder traversal and see if it is sorted
        while root or stk:
            while root:
                stk.append(root)
                root = root.left
            curr = stk.pop()
            
            if prev!=None and prev>=curr.val:
                return False
            prev = curr.val
    
            root = curr.right
            
        return True

# Time complexity: O(m+n) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.