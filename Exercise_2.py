# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time Complexity = O(n)
# Space Complexity = O(n)

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
      
        if not preorder or not inorder:
            return None
        
        #root
        root=TreeNode(preorder[0])
        
        #find the root inorder
        rootIndex = inorder.index(preorder[0])

                
        inLeft = inorder[:rootIndex]
        inRight = inorder[rootIndex+1:]
        preLeft = preorder[1:rootIndex+1]
        preRight = preorder[rootIndex+1:]
        
        root.left = self.buildTree( preLeft, inLeft)
        root.right = self.buildTree( preRight, inRight)
        
        return root