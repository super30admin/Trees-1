# Time Complexity: O(n)
# The hashmap allows finding the root's index in O(1) time, making the overall time complexity O(n).

# Space Complexity: O(n)
# O(n) space is used for the recursion stack and the hashmap.

# Approach:
# - Build a hashmap from the inorder list to store element indices.
# - Use preorder's first element as the root and find its index in inorder.
# - Recursively construct the left and right subtrees using the corresponding preorder and inorder slices.

class Solution(object):
    def buildTree(self, preorder, inorder):
        midIdx = {n: i for i, n in enumerate(inorder)}
        if not (preorder or inorder):
            return None
        root = TreeNode(preorder[0])
        mid = midIdx[preorder[0]]
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        return root
