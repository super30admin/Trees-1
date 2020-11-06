# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def isValidBST1(self, root):
		return self.helper(root, None, None)

	def helper1(self, root, minVal, maxVal):
		if root == None:
			return True
		if minVal != None and root.val <= minVal:
			return False
		if maxVal != None and root.val >= maxVal:
			return False
		return self.helper(root.left, minVal, root.val) and self.helper(root.right, root.val, maxVal)

	def isValidBST2(self, root):
		if root == None:
			return True
		prev = None
		stack = []
		while(root != None or len(stack) > 0):
			while(root != None):
				stack.append(root)
				root = root.left
			root = stack.pop()
			if prev != None and root.val <= prev.val:
				return False
			prev = root
			root = root.right
		return True

	prev = None
	def isValidBST3(self, root):
		self.prev = None
		return self.helper(root)

	def helper3(self, root):
		if root == None:
			return True
		if not self.helper3(root.left):
			return False
		if self.prev != None and root.val <= self.prev.val:
			return False
		self.prev = root
		return self.helper3(root.right)