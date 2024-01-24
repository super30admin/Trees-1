# Trees-1
## Problem 2
#105. Construct Binary Tree from Preorder and Inorder Traversal
# Time Complexity = O(n*2)
# Space Complexity = O(n*2)

class Solution(object):
    def buildTree(self, preorder, inorder):

        if inorder:
            #Index of root element via preorder traversal to use for slicing in inorder.
            indx = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[indx])
            root.left = self.buildTree(preorder, inorder[0:indx])
            root.right = self.buildTree(preorder, inorder[indx + 1:])
            return root

        
        
