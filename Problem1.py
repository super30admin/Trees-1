# Time Complexity (TC): O(n)
# The function visits every node in the tree exactly once, where n is the number of nodes in the tree.

# Space Complexity (SC): O(h), where h is the height of the tree.
# The space complexity is O(h) due to the recursive call stack, which in the worst case (for an unbalanced tree) 
# could be O(n), but in the best case (balanced tree) is O(log n).

# Approach:
# The function checks if a binary tree is a valid binary search tree (BST) by using a recursive helper function 'valid'.
# It ensures each node's value is within a valid range, defined by the 'left' and 'right' boundaries.
# The root node must be greater than all nodes in the left subtree and less than all nodes in the right subtree.
# For each subtree, the function narrows down the allowed range: the left child's maximum allowed value is the root's 
# value, and the right child's minimum allowed value is the root's value. This process continues recursively down the tree.

class Solution(object):
    def isValidBST(self, root):
        def valid(root, left, right):
            if not root:
                return True
            if not (root.val > left and root.val < right):
                return False
            return (valid(root.left, left, root.val) and valid(root.right, root.val, right))

        return valid(root, float("-inf"), float("inf"))
