#
# Time Complexity = O(n^2)
# Space Complexity = O(n) 
# Works on leetcode
#


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        inorder_index={}
        def rec(si,li,sp,lp):
            if sp>lp:
                return None
            curr = preorder[sp]
            root = TreeNode(curr)
            nl = inorder_index[curr] - si
            root.left = rec(si,inorder.index(curr)-1,sp+1,sp+nl)
            root.right = rec(inorder.index(curr)+1,li,sp+nl+1,lp )
            return root
        n = len(preorder)
        for i,v in enumerate(inorder):
            inorder_index[v]=i
        return rec(0,len(preorder)-1,0,len(preorder)-1)
