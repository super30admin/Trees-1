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
        :rtype: TreeNode
        """
        # Subimtted successfully
        # TC = O(n): recursive call through nodes
        # SC = O(n): hashmap
        # Optimized

        self.idx = 0

        hmap = {}
        for j in range(len(inorder)):
            hmap[inorder[j]] = j

        def build(preorder, inorder, left, right):

            # base case
            if left > right:
                return None

            # root in preorder is every element starting from left
            root_val = preorder[self.idx]
            root = TreeNode(root_val)
            self.idx += 1

            # find index of root in inorder array
            r_idx = hmap[root_val]

            root.left = build(preorder, inorder, left, r_idx - 1)
            root.right = build(preorder, inorder, r_idx + 1, right)

            return root

        return build(preorder, inorder, 0, len(inorder) - 1)