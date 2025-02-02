#space: O(height of recursive stack)
#Time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.iset= dict()
        self.idx=0
        for i in range(len(inorder)):
            self.iset[inorder[i]]=i

        return self.createTree(preorder, 0, len(preorder)-1)

    def createTree(self, preorder, start, end):
        
        if start > end:
            return
        rootval= preorder[self.idx]
        self.idx +=1
        root = TreeNode(rootval)
        rootidx= self.iset.get(rootval)
        root.left= self.createTree(preorder, start, rootidx-1)
        root.right= self.createTree(preorder, rootidx + 1, end)
        
        return root
