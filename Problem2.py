class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if inorder:
            idx =  inorder.index(preorder.pop(0))
            root= TreeNode(inorder[idx])
            root.left= self.buildTree(preorder,inorder[0:idx])
            root.right= self.buildTree(preorder,inorder[idx+1:])
            return root
