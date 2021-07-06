# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def helper(preorder, inorder, start, end):
            nonlocal index
            # base
            if start > end or index == len(preorder):
                return None
            
            # body
            root = TreeNode(preorder[index])
            node_index = inorder_map[root.val]
            index+=1
            root.left = helper(preorder, inorder, start, node_index-1)
            root.right = helper(preorder, inorder, node_index+1, end)
            return root
            
        index = 0
        inorder_map = {}
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        start = 0
        end = len(preorder) - 1
        return helper(preorder, inorder, 0, len(preorder)-1)