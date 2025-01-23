# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC : O(n)
    # SC : O(n)

    def createTree(self,preorder : List[int],start:int,end:int):
        if start > end:
            return None
        rootval = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootval)
        rootIdx = self.hmap[root.val]
        root.left = self.createTree(preorder,start,rootIdx-1)
        root.right = self.createTree(preorder,rootIdx+1,end)
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
         
        if preorder is None or len(preorder) == 0 or len(inorder) == 0:
            return None
        self.idx = 0
        self.hmap = {}
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        return self.createTree(preorder,0,len(preorder)-1)
        