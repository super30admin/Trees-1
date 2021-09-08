# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursive solution using min and max for each root
    """
    TC: O(n)
    SC: O(max. depth of the tree) --> little more than iterative approach
    """

    def recurr(self, node, minimum, maximum):

        if node == None:
            return True

        if node.val >= maximum or node.val <= minimum:
            return False

        if self.recurr(node.left, minimum, node.val) and self.recurr(node.right, node.val, maximum):
            return True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        if root == None:
            return True

        maximum = float('inf')
        minimum = float('-inf')

        return self.recurr(root, minimum, maximum)
