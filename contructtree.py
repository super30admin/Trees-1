def buildTree(self, preorder, inorder):
        
        
        
  if inorder:   

    index = inorder.index(preorder.pop(0))
    root = TreeNode(inorder[index])
    root.left = self.buildTree(preorder, inorder[:index])
    root.right = self.buildTree(preorder, inorder[index+1:])
    return root
    
    ''' first element of preorder is the root node, find that element in inorder, it bisects left and right subtree. Recursively,it will buid a tree.
        space and time complexity is o(n)'''
