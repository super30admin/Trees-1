# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def buildTree1(self, preorder, inorder):
		if len(preorder) == 0:
			return None
		root = TreeNode(preorder[0])
		rootidx = -1
		for index, val in enumerate(inorder):
			if val == root.val:
				rootidx = index
		inleft = inorder[:rootidx]
		preleft = preorder[1:rootidx + 1]
		inright = inorder[rootidx + 1:]
		preright = preorder[rootidx + 1:]
		root.left = self.buildTree(preleft, inleft)
		root.right = self.buildTree(preright, inright)
		return root

	def buildTree2(self, preorder, inorder):
		# Optimized version of the above code
		map_inorder = dict()
		for index, val in enumerate(inorder):
			map_inorder[val] = index
		return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, map_inorder)

	def helper(self, preorder, prestart, preend, inorder, instart, inend, map_inorder):
		if prestart > preend or instart > inend:
			return None
		rootVal = preorder[prestart]
		rootidx = map_inorder[rootVal]
		root = TreeNode(rootVal)
		num_left = rootidx - instart
		root.left = self.helper(preorder, prestart + 1, prestart + num_left, inorder, instart, rootidx - 1, map_inorder)
		root.right = self.helper(preorder, prestart + num_left + 1, preend, inorder, rootidx + 1, inend, map_inorder)
		return root