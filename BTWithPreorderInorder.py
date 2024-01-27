# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashMap = dict()
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder)-1)

    def helper(self, preorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        if start > end:
            return None
        rootVal = preorder[self.idx]
        self.idx += 1
        rootIdx = self.hashMap[rootVal]
        root = TreeNode(rootVal)
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)
        return root

#Time and Space Complexity O(n)