class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        map={}
        self.index=0
        for i in range(len(inorder)):
            map[inorder[i]]=i
        return self.helper(preorder,0,len(inorder)-1,map)

    def helper(self,preorder,start,end,map):
        if start>end:
            return None

        root_val=preorder[self.index]
        self.index+=1
        root=TreeNode(root_val)
        root_idx=map[root_val]

        root.left=self.helper(preorder,start,root_idx-1,map)
        root.right=self.helper(preorder,root_idx+1,end,map)

        return root