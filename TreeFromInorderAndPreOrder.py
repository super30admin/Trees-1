"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    idx = 0
    hashmap={}
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        #optimized solution T.C and S.C is O(N)
        self.hashmap = {}
        for i in range(0,len(inorder)):
            self.hashmap[inorder[i]]=i
        return self.helper(preorder,inorder,0,len(preorder)-1)
    def helper(self,preorder,inorder,start,end):
        #base
        
        if start>end:
            return None
        rootVal = preorder[self.idx]
        self.idx +=1
        root = TreeNode(rootVal)
        rootIndex = self.hashmap.get(rootVal)
        root.left = self.helper(preorder,inorder,start,rootIndex - 1)
        root.right = self.helper(preorder,inorder,rootIndex+1,end)
        return root 
        
        
        
        #Brute Force Approach T.C and S.C = O(n^2)      
        # if len(preorder)==0:
        #     return None
        # rootVal = preorder[0]
        # root=TreeNode(rootVal)
        # index = -1
        # for i in range(0,len(inorder)):
        #     if(rootVal==inorder[i]):
        #         index = i
        #         break
        # inorderLeft = inorder[0:index]
        # inorderRight = inorder[index+1:len(inorder)]
        # preorderLeft = preorder[1:index+1]
        # preorderRight = preorder[index+1:len(preorder)]
        # root.left = self.buildTree(preorderLeft,inorderLeft)
        # root.right = self.buildTree(preorderRight,inorderRight)
        # return root
        