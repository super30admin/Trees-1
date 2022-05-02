# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def recursive(left, right):
            nonlocal pindex
            if left > right:
                return None

            root_val = preorder[pindex]

            root = TreeNode(root_val)
            pindex = pindex + 1
            index = position[root_val]
            root.left = recursive(left, index - 1)

            root.right = recursive(index+1, right)
            return root

        pindex = 0
        position = {}
        for index, val in enumerate(inorder):
            position[val] = index

        size = len(preorder)
        return recursive(0, size - 1)
