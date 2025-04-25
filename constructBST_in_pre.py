def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # base
        if not preorder or not inorder:
            return None
        print(preorder[0])
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        print(root)
        # find rootval in inorder
        nr = -1
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                nr = i
                
        preleft = preorder[1:nr+1]
        inleft = inorder[:nr]
        preright = preorder[nr+1:]
        inright = inorder[nr+1:]

        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)

        return root