#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        self.idx = 0
        inorder_map = {val: i for i, val in enumerate(inorder)}
        return self.helper(preorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, preorder, start, end, inorder_map):
        if start > end:
            return None

        root_val = preorder[self.idx]
        self.idx += 1
        root = TreeNode(root_val)

        root_idx = inorder_map[root_val]

        root.left = self.helper(preorder, start, root_idx - 1, inorder_map)
        root.right = self.helper(preorder, root_idx + 1, end, inorder_map)

        return root
        