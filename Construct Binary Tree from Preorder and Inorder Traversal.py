# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
TC: O(n)
SC: O(n)
"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) < 1 :
            return;
        
        rootval = preorder[0]
        root = TreeNode(rootval)
        rootidx = -1
        for idx in range(len(inorder)):
            if inorder[idx] == rootval:
                rootidx = idx
                break
        inLeft = inorder[:rootidx]
        inRight = inorder[rootidx+1:]
        
        preLeft = preorder[1:len(inLeft)+1]
        preRight = preorder[len(inLeft)+1:]
        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)
        return root
        
        
