# S30 Big N Problem #41 {Medium}
# LC pproblem - 105

# Recursive approach

# Construct Binary Tree from Preorder and Inorder Traversal

# Time Complexity : O(nlogn) n=no. of nodes in the tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        root=TreeNode(0)
        
        return self.helper(0,0,len(inorder)-1,preorder,inorder)
    
    def helper(self,preroot,instart,inend,preorder,inorder):
        
        
        if preroot >=len(preorder) or instart>inend:
            return None
        
        iindex=0
        for i in range(instart,inend+1,1):
            if inorder[i]==preorder[preroot]:
                iindex=i
                break
                
        root=TreeNode(preorder[preroot])
                
        root.left=self.helper(preroot+1,instart,iindex-1,preorder,inorder)
        root.right=self.helper(preroot+1+iindex-instart,iindex+1,inend,preorder,inorder)
        
        return root 
            
        