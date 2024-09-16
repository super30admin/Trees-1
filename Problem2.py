# problem2: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


#Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:        
        if len(preorder) is None and len(inorder) is None:
            return None
        global h
        h={}
        global index
        index=0
        for i in range(len(inorder)):
            h[inorder[i]]=i
        return self.helper(preorder,inorder,0,len(inorder)-1)
        
    def helper(self,preorder,inorder,start, end):
        global index
        global h
        
        # edge case
        if index == len(preorder) or start > end:
            return None
        
        # root index
        rootindex=h[preorder[index]]
        root=TreeNode(preorder[index])
        index+=1
        root.left=self.helper(preorder,inorder,start,rootindex-1)
        root.right=self.helper(preorder,inorder,rootindex+1,end)
        
        return root