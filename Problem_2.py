"""
Time Complexity : O(n) as we go through the inorder and store the indexes and then again iterate through all the
elements one
Space Complexity : O(n) as we are storing n values in a dictionary 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Firstly, we did a solution, wherein at every point, I was sending a copy of inorder array to the 
recursive method. But that is very time consuming, O(n^2) as first we find index of a value and at every 
value, we are making array copis and passing. It is expensive space wise as well as we are making array copies
at every point. So, in another approach, we make a hashmap storing index of values from an inorder array
which makes fetching the index O(1). Then, we only pass the index of start and ending position from inorder
array and modify the index from preorder array to iterate through all of them once. This increased the
efficiency exponentially.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.d = {}
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        global idpre
        idpre = 0
        return self.helper(0, len(inorder), preorder, inorder)

    def helper(self, start, end, preorder, inorder):
        global idpre
        if start >= end:
            return
        value = preorder[idpre]
        index = self.d[value]
        root = TreeNode(value)
        idpre += 1
        root.left = self.helper(start, index, preorder, inorder)
        root.right = self.helper(index+1, end, preorder, inorder)
        return root


# class Solution(object):
#     def buildTree(self, preorder, inorder):
#         """
#         :type preorder: List[int]
#         :type inorder: List[int]
#         :rtype: TreeNode
#         """
#         if inorder:
#             idx=inorder.index(preorder.pop(0))
#             root=TreeNode(inorder[idx])
#             root.left= self.buildTree(preorder,inorder[:idx])
#             root.right= self.buildTree(preorder,inorder[idx+1:])
#             return root
