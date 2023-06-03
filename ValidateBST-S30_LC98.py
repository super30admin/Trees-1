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
        # Submitted successfully
        # TC = O(n) where n is the number of nodes
        # SC = O(h) where h is height/depth of tree
        # DFS

        # base case
        if root == None:
            return True

        self.res = True
        self.prev = None

        def inorder(node):
            if node == None:
                return

            inorder(node.left)

            # IMPORTANT
            # checking if inorder traversal has elements in ascending order
            if self.prev != None and self.prev.val >= node.val:
                self.res = False
            self.prev = node

            inorder(node.right)

        inorder(root)

        return self.res