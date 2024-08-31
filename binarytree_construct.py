# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#O(n)^2
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        rootIn = preorder[0]
        root = TreeNode(rootIn)

        
        for i in range(len(inorder)):
            if inorder[i] == rootIn:
                rootindx = i
                break
        inorder_left = inorder[0:rootindx]
        inorder_right = inorder[rootindx+1:]
        preorder_left = preorder[1:1+len(inorder_left)]
        preorder_right = preorder[len(inorder_left)+1:]

        root.left = self.buildTree(preorder_left,inorder_left)
        root.right = self.buildTree(preorder_right,inorder_right)

        return root
        
        