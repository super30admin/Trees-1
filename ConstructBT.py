# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : Yes
// always make first elemnt of the proorder as root
// calculate preleft, preright, inleft, inright arrays and call the build tree function iteratively.
class Solution(object):
    def 
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if(len(preorder)==0):
            return None
        root = TreeNode(preorder[0])
        rootidx=-1
        for index,val in enumerate(inorder):
            if val == root.val:
                rootidx = index
         
        inleft = inorder[:rootidx]
        inright=inorder[rootidx+1:]
        preleft =preorder[1:rootidx+1]
        preright=preorder[rootidx+1:]
        root.left=self.buildTree(preleft,inleft)
        root.right=self.buildTree(preright,inright)
        return root
        
        
        
