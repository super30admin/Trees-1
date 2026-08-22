#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.helper(root, None, None)

    def helper(self, root, minimum, maximum):
        if root is None:
            return True

        if minimum is not None and minimum >= root.val:
            return False

        if maximum is not None and maximum <= root.val:
            return False

        return self.helper(root.left, minimum, root.val) and self.helper(root.right, root.val, maximum)
        