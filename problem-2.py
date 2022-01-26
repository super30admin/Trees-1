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
    def __init__(self):
        self.index=0
        self.mapp={}
        # we first keep index to track preorder root nodes and mapp hash map for index look up from inorder array.
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i,x in enumerate(inorder):
            self.mapp[x]=i
            
        return self.helper(preorder,0,len(inorder)-1 )
    # we will maintain start and end pointer to reduce space complexity and recursively build left then right sub trees by calling helper for root.left and root,right and return the root to above node there by creating the connection 
    def helper(self,preorder, start,end):
       
        if start>end:
            return None
        
        root=TreeNode(preorder[self.index])
        self.index+=1
        root.left=self.helper(preorder,start,self.mapp[root.val]-1)
        root.right=self.helper(preorder,self.mapp[root.val]+1,end)
        return root
        
    
        