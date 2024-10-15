# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.hash_map = {}
        self.idx = 0
        self.hash_map = {val: idx for idx, val in enumerate(inorder)}
        # preorder list is used for determining root of binary tree at each level and start as well as end poointers are used for traversing through the inorder array to get the left and right subtree at each level
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        if start > end:
            return None

        rootval = preorder[self.idx]
        self.idx += 1

        root = TreeNode(rootval)

        rootIdx = self.hash_map[rootval]

        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)

        return root


# time complexity is O(n) where n is the number of elements in either preorder or inorder
# space complexity is O(n) where n is the number of elements in either preorder or inorder
