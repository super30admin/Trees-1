# TC: O(n), SC: O(n): Recursion with Hashmap Approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(preorder, start, end):
            if start > end:
                return None
            rootVal = preorder[self.preIdx]
            rootIdx = hashmap[rootVal]
            self.preIdx += 1
            root = TreeNode(rootVal)
            root.left = helper(preorder, start, rootIdx-1)
            root.right = helper(preorder, rootIdx+1, end)
            return root

        if not preorder or not inorder:
            return None
        hashmap = {}
        self.preIdx = 0
        for i in inorder:
            hashmap[i] = inorder.index(i)
        return helper(preorder, 0, len(preorder) -1)