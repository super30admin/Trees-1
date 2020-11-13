# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    _inodermap={}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        #base
        if len(preorder)==0 or len(inorder)==0: return None
        #self.createmap(inorder)
        #logic
        root=TreeNode(preorder[0])
        
        rootidx=inorder.index(preorder[0])
        
        preleft=preorder[1:rootidx+1]
        
        preright=preorder[rootidx+1:len(preorder)]
        
        inleft=inorder[0:rootidx+1]
        inright=inorder[rootidx+1:len(inorder)]
        root.left=self.buildTree(preleft,inleft)
        root.right=self.buildTree(preright,inright)
       
        return root
    
    
    def createmap(self,inorder):
        for i,val in enumerate(inorder):
            self._inordermap[val]=i
        