# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity :
# O(N) since we visit each node exactly once.
# Space complexity :
# O(N) since we keep up to the entire tree.
class Solution:
    preIndex = 0
    inoderMap = defaultdict(int)

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for idx, val in enumerate(inorder):
            self.inoderMap[val] = idx
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, leftIdx, rightIdx):

        if leftIdx > rightIdx:
            return None
        root = TreeNode(preorder[self.preIndex])
        self.preIndex += 1
        root.left = self.helper(preorder, leftIdx, self.inoderMap[root.val] - 1)
        root.right = self.helper(preorder, self.inoderMap[root.val] + 1, rightIdx)
        return root
