#Trees-1
#Problem2 : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
#All test cases passed on Leetcode
#Time Complexity-O(N)
#Space Complexity-O(N)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
       
       
class Solution:
    idx=0
    def helper(self,preorder,inorder,start,end):
        #base
    
        if  start>end:
            return
        #logic
        global idx
        #find the root index in the inorder traversal
        #print(idx)
        rootidx=dict1[preorder[idx]]
        #print(rootidx)
        root=TreeNode(preorder[idx])
        idx+=1
        root.left=self.helper(preorder,inorder,start,rootidx-1)
        root.right=self.helper(preorder,inorder,rootidx+1,end)
        return root
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        global idx
        idx=0
        #print(idx)
    
        global dict1
        dict1={}
        for i in range(len(inorder)):
            dict1[inorder[i]]=i
        #print(dict1)
        return self.helper(preorder,inorder,0,len(inorder)-1)
        


        
        















