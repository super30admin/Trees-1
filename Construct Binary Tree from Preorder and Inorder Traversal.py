# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if(not preorder):
            return
        idx = inorder.index(preorder[0])
        root = TreeNode(inorder[idx])
        root.left = self.buildTree(preorder[1:len(inorder[0:idx])+1],inorder[0:idx])
        root.right = self.buildTree(preorder[len(inorder[0:idx])+1::],inorder[idx+1::])
        
        return root