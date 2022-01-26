# Leetcode Execution: YES
# TC: O(n)
# SC: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # we process the bt inorder to get all the elemnts in the tree inorder and then check if it sorted if not then return fasle else return True
        
        inorder=self.helper(root,[])
        # print(inorder)
       
        for i,x in enumerate(inorder):
            if i>0 and x<=inorder[i-1]:
                return False
            
        return True
        
        
    def helper(self,root, arr):
        
        if root==None:
            return 
        self.helper(root.left, arr)
        arr.append(root.val)
        self.helper(root.right,arr)
        return arr
        
        
        