"""
We have a base case that says if node doesnt exist, return. Then we check each node on left and right and use the
helper function to check the range of the values that node can hold. If within bounds, return true
TC is O(N) and SC is O(1) since we dont use auxiallry space
"""
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        def isValid(node, minn, maxx):

            if not node:
                return True #base case
            if node.val <= minn or node.val >= maxx: #checks the range(minn, maxx)
                return False
            return isValid(node.left, minn, node.val) and isValid(node.right, node.val, maxx)
        return isValid(root, float('-inf'), float('inf'))
