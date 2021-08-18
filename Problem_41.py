class Solution:

        #Time complexity O(n)
        #Space complexity O(h) --> h is height of the tree

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

if __name__ == '__main__':

root=Solution(3)
root.left=Solution(4)
root.right=Solution(9)
root.left.left=Solution(5)
root.left.right=Solution(6)
root.right.left=Solution(8)
root.right.right=Problem(10)



