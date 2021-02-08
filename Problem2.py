# Time Complexity :O(n) where n is number of nodes
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 98

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def isValidBSTHelper(currNode, minVal, maxVal):

            if currNode is None:
                return True

            if currNode.val <= minVal or currNode.val >= maxVal:
                return False

            leftValid = isValidBSTHelper(currNode.left, minVal, currNode.val)
            return leftValid and isValidBSTHelper(currNode.right, currNode.val, maxVal)

        return isValidBSTHelper(root, float("-inf"), float("inf"))


root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)

print(Solution().isValidBST(root))