# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.idx = 0
        pos = {v: i for i, v in enumerate(inorder)}
        return self.buildfromlists(preorder, 0, len(inorder) - 1, pos)

    def buildfromlists(self, preorder: List[int], low: int, hi: int, pos: dict) -> Optional[TreeNode]:
        if low > hi:
            return None
        val = preorder[self.idx]
        self.idx += 1
        root = TreeNode(val)
        mid = pos[val]
        root.left = self.buildfromlists(preorder, low, mid - 1, pos)
        root.right = self.buildfromlists(preorder, mid + 1, hi, pos)
        return root
