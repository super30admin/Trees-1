# Time Complexity : O(N) 
# Space Complexity :    O(N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        self.map = {}
        self.idx = 0
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder)-1)

    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> TreeNode:
        if start > end:
            return None
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        rootIdx = self.map[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)
        return root 