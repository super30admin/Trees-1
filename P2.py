# -*- coding: utf-8 -*-
"""
Created on Tue Apr 13 16:52:02 2021

@author: jgdch
"""

#Time Complexity:O(N), N is the number of ndoes in the tree
#Space Complexity:O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.index=0
        self.hmap={}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i
        #print(self.hmap)
        return self.helper(preorder,0,len(preorder)-1)
    def helper(self,preorder,start,end):
        #print(self.index)
        
       
        if(start>end):
            return None
        root=TreeNode(preorder[self.index])
        self.index+=1
        ind=self.hmap[root.val]
        root.left=self.helper(preorder,start,ind-1)
        root.right=self.helper(preorder,ind+1,end)
        return root
        
        