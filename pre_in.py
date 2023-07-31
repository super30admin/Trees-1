class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if(len(preorder)==0):
            return None
        ind=-1
        root=TreeNode (preorder[0])

        
        for i in range(len(inorder)):
            if(inorder[i]==root.val):
                ind=i
                break
        # pre_right=preorder[ind+1:]
        # pre_left= preorder[1:ind+1]
        # in_left=inorder[:ind]
        # in_right=inorder[ind+1:]

        root.left=self.buildTree(preorder[1:ind+1], inorder[:ind])
        root.right=self.buildTree(preorder[ind+1:], inorder[ind+1:])
        return root
