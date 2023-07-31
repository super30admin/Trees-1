class Solution(object):
    def isValidBST(self, root):
        """
        Time complexity: O(N), N -> number of nodes in the binary tree
        Space complexity: O(H), H -> height of the binary tree
        :type root: TreeNode
        :rtype: bool
        """
        # Initialize prev node and flag
        self.prev = None
        self.flag = True

        # Call the inorder traversal function
        self.inorder(root)

        return self.flag

    def inorder(self, root):
        # Check if the flag is already False or the root is None
        if not self.flag or root is None:
            return

        # Traverse the left subtree recursively
        self.inorder(root.left)

        # Check the validity of the current node
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        # Update prev node to the current node
        self.prev = root

        # Traverse the right subtree recursively
        self.inorder(root.right)
