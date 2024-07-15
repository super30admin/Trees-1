# time: O(n)
# space: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ind = 0
    map = {}
    def helper(self, preorder, inorder, start, end):
        if start>end:
            return
        
        rootVal = preorder[self.ind]
        rootInd = self.map[rootVal]
        self.ind+=1
        root = TreeNode(rootVal)
        root.left = self.helper(preorder, inorder, start, rootInd-1)
        root.right = self.helper(preorder, inorder, rootInd+1, end)

        return root
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0:
            return 

        for i in range(len(inorder)):
            self.map[inorder[i]] = i

        return self.helper(preorder, inorder, 0, len(preorder)-1)


        
        