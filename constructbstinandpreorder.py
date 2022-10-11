##Time Complexity : O(n)
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes
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
        self.index = 0
        def recursive(preorder, inorder, start, end):
        	if start > end:
        		return None

        	node = TreeNode(preorder[self.index])
        	self.index += 1
        	if start == end:
        		return node

        	search_index = 0
        	for i in range(start, end+1):
        		if inorder[i] == node.val:
        			search_index = i
        			break

        	node.left = recursive(preorder, inorder, start, search_index-1)
        	node.right = recursive(preorder, inorder, search_index+1, end)
        	return node

        return recursive(preorder, inorder, 0, len(inorder)-1)
      
