# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
        if(len(preorder) == 0):
            return None
        
        root = TreeNode(preorder[0])
        index = -1
        
        for x in range(0, len(inorder)):
            if inorder[x] == root.val:
                index = x
        
        preLeft = preorder[1:index+1]
        inLeft = inorder[0:index]
        preRight = preorder[index+1:len(preorder)]
        inRight = inorder[index+1:len(inorder)]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root
