def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
    self.idx=0
    inordermap={val:i for i,val in enumerate(inorder)}
    return self.helper(preorder,0,len(inorder)-1,inordermap)
    
def helper(self, preorder, start, end,inordermap):
    if start>end:
        return
    root_val=preorder[self.idx]
    self.idx+=1
    root=TreeNode(root_val)

    root_idx=inordermap[root.val]
    root.left=self.helper(preorder,start,root_idx-1,inordermap)
    root.right=self.helper(preorder,root_idx+1, end,inordermap)
    return root
    