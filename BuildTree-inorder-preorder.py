# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted by leetcode
#Time complexity - O(n) because we are travesing through inorder array
#Space complexity - O(n) because we are using extra arrays inleft, inright, preleft, preright

"""Doubts - The following code runs on Leetcode. But,
		If I use root.left = buildTree(self, preleft, inleft)
		
        instead of
		
		root.left = buildTree(self, preleft, inleft)
		
		I get NameError: global name 'buildTree' not defined. Why is it so?
"""
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        #Edge case
        if len(preorder) == 0:
            return None        
        root = TreeNode(preorder[0])
        rootindx = -1
        for i,val in enumerate(inorder):
            if val == root.val:
                rootindx = i
        inleft = inorder[:rootindx]
        inright = inorder[rootindx+1:]
        preleft = preorder[1:rootindx+1]
        preright = preorder[rootindx+1:]
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root        