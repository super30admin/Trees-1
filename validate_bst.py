# Approach:
# Use iterative inorder traversal (left → root → right).
# Keep track of the previous value and ensure it's always less than the current node's value.

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = float('-inf')  # Smallest possible number to start comparison
        stack = []

        while root or stack:
            # Go as left as possible
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()

            # Check if current node is greater than previous (inorder should be increasing)
            if prev >= root.val:
                return False
            prev = root.val

            # Move to the right subtree
            root = root.right

        return True

# Time Complexity: O(n)
# Space Complexity: O(h), where h is the tree height (stack)
