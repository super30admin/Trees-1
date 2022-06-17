# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # self.idx = 0
        d = dict()
        for i in range(len(inorder)):
            if(inorder[i] not in d):
                d[inorder[i]] = i
        return self.const(preorder, inorder, d, 0, len(inorder)-1)
    
    def const(self, preorder, inorder, d, start, end):
        if(start > end):
            return None
        rootval = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootval)
        rootidx = d[rootval]
        root.left = self.const(preorder, inorder, d, start, rootidx-1)
        root.right = self.const(preorder, inorder, d, rootidx+1, end)
        return root
        
        
        
#         root =TreeNode()
#         self.const(root, preorder, inorder)
#         return root
        
#     def const(self, root, preorder, inorder):
#         if(len(preorder) == 0 and len(inorder) == 0):
#             return
#         root.val = preorder[0]
#         for i in range(len(inorder)):
#             if(inorder[i] == root.val):
#                 rootidx = i
#         inleftsub = inorder[0:rootidx]
#         inrightsub = inorder[rootidx+1:]
#         preleftsub = preorder[1: 1+ len(inleftsub)]
#         prerightsub = preorder[1+ len(inleftsub):]
#         if(len(preleftsub)):
#             root.left = TreeNode()
#         if(len(prerightsub)):
#             root.right = TreeNode()
#         self.const(root.left, preleftsub, inleftsub)
#         self.const(root.right, prerightsub, inrightsub)
        
        
        
        
        