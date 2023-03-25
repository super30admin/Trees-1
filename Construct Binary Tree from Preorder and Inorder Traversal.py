# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        global preIdx
        preIdx = 0
        global inorder_hmap
        inorder_hmap = {}
        for i in range(len(inorder)):
            inorder_hmap[inorder[i]] = i

        def recurse(preorder, start, end):
            # Base Case
            if start > end: return None
            # Logic
            global preIdx
            global inorder_hmap
            rootval = preorder[preIdx]
            # print(inorder_hmap)
            rootIdx = inorder_hmap[rootval]
            preIdx += 1
            root = TreeNode(rootval)
            root.left = (recurse(preorder, start, rootIdx - 1))
            root.right = (recurse(preorder, rootIdx + 1, end))
            return root

        return recurse(preorder, 0, len(inorder) - 1)