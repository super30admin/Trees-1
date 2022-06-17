# Definition for a binary tree node.
#TC: O(n^2)
class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if len(preorder)==0: return None
        rootVal=preorder[0]
        rootIdx=-1
        root=TreeNode(rootVal)
        for i in range(0,len(inorder)):
            if preorder[0]==inorder[i]:
                rootIdx=i
                break
        inLeft=inorder[:rootIdx]
        inRight=inorder[rootIdx+1:]
        preLeft=preorder[1:1+rootIdx]
        preRight=preorder[1+rootIdx:]
        root.left=self.buildTree(preLeft,inLeft)
        root.right=self.buildTree(preRight,inRight)
        return root