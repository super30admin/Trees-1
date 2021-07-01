# Time Complexity: O(n), where n is length of input arrays
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or len(preorder) == 0:
            return None

        self.preorder_idx = 0

        # Hashmap to store the indices of the inorder values
        self.inorder_idx_map = dict()
        for i in range(len(inorder)):
            self.inorder_idx_map[inorder[i]] = i

        return self.helper(preorder, 0, len(preorder) - 1)


    def helper(self, preorder: List[int], start: int, end: int) -> TreeNode:
        # If there are no elements to build the tree
        if start > end:
            return None

        # Consider preorder_idx element as the root and build its left and right subtree using inorder indices
        rootval = preorder[self.preorder_idx]
        self.preorder_idx += 1
        root = TreeNode(rootval)

        inorder_idx = self.inorder_idx_map[rootval]
        root.left = self.helper(preorder, start, inorder_idx - 1)
        root.right = self.helper(preorder, inorder_idx + 1, end)

        return root


