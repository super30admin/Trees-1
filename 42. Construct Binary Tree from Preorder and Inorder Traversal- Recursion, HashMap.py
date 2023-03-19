# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    index = 0
    hashMap = dict()

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder is None or len(preorder) == 0 or len(inorder) == 0 or preorder is None:
            return None

        self.hashMap = dict()
        self.index = 0

        for index, value in enumerate(inorder):
            self.hashMap[value] = index

        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, start, end):
        # base case
        if start > end:
            return None
        # logic
        rootVal = preorder[self.index]
        self.index += 1
        root = TreeNode(rootVal)

        rootIdx = self.hashMap.get(rootVal)  ## returns root index

        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)
        return root

# recursion, HashMap
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
