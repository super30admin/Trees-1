class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        #Edge case
        if len(preorder) == 0:
            return None        
        root = TreeNode(preorder[0])
        rootindx = -1
        for i,val in enumerate(inorder):
            if val == root.val:
                rootindx = i
        inleft = inorder[:rootindx]
        inright = inorder[rootindx+1:]
        preleft = preorder[1:rootindx+1]
        preright = preorder[rootindx+1:]
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root        