class Solution:
    dic = {}
    index = 0
    def helper(self,preorder: List[int], inorder: List[int], low: int, high: int ) -> Optional[TreeNode]:
        if low > high:
            return 
        rootValue = preorder[self.index]
        self.index = self.index + 1
        
        newRoot = TreeNode(rootValue)
        rootIndex = self.dic.get(rootValue)
        newRoot.left = self.helper(preorder, inorder, low, rootIndex-1)
        newRoot.right = self.helper(preorder, inorder,rootIndex + 1, high)
        
        return newRoot
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        for i in range(len(inorder)):
            self.dic[inorder[i]] = i
            
        return self.helper(preorder, inorder, 0 , len(inorder) - 1)
    
    #Done
        