# Time Complexity: O(n) - number of tree nodes
# Space Complexity: O(h) - height of tree - recursive stack space
# Approach:
# Traverse the tree inorder, recursively to get the nodes in ascending order of value
# At every node, save a pointer to the previous node
# Return False if the BST property is violated - current value is less than previous
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):

    def isValidBST(self, root):
        self.prev = None

        """
        :type root: TreeNode
        :rtype: bool
        """
        
        def inorder(root):
            if root is None:
                return True
            if not inorder(root.left): return False
            if self.prev is not None and root.val <= self.prev.val:
                return False
            self.prev = root
            return inorder(root.right)
        
        # prev = [None]
        return inorder(root)