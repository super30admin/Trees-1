# TC : O(N)
# SC : O(N)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        output =[]
        self.inorder(root, output)

        for i in range(1, len(output)):
		            if output[i-1]>= output[i]: 
                                return False

        return True

    def inorder(self, root, output):
        if root is None:
            return

        self.inorder(root.left, output)
        output.append(root.val)
        self.inorder(root.right, output)


