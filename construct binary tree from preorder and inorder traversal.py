##Time Complexity : O(n)
# constant lookups for finding root index
##Space Complexity : O(n)
# hashmap

# Definition for a binary tree node.


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.preOrderIndex = 0
        self.mapper = dict()

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        for index in range(len(inorder)):
            self.mapper[inorder[index]] = index

        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        # base case
        if start > end:
            return None
        # logic
        rootVal = preorder[self.preOrderIndex]
        root = TreeNode(rootVal)
        self.preOrderIndex += 1
        rootIndex = self.mapper[rootVal]
        root.left = self.helper(preorder, start, rootIndex - 1)  # left
        root.right = self.helper(preorder, rootIndex + 1, end)  # right
        return root
