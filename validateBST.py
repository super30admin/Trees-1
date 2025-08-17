# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def __init__(self):
        # flag tracks whether we've seen any BST violation during traversal
        self.flag = True
        # prev stores the previously visited node in inorder traversal
        self.prev = None

    def helper(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return

        # Traverse left subtree
        self.helper(root.left)

        # Inorder of a valid BST is strictly increasing.
        # If current value is not greater than previous, it's invalid.
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False

        # Update prev to current before going right
        self.prev = root

        # Traverse right subtree
        self.helper(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Run inorder traversal to check ordering property
        self.helper(root)
        return self.flag
