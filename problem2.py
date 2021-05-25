class Solution:
    def __init__(self):
        self.idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0:
            return None
        dictmap = dict()
        for i in range(len(inorder)):
            dictmap[inorder[i]] = i
        val = self.helper(preorder,inorder,0,len(preorder)-1,dictmap)
        return val

    def helper(self,preorder,inorder,start,end,dictmap):
        if start>end :
            return None


        root = TreeNode(preorder[self.idx])
        hashvalue = dictmap[preorder[self.idx]]
        self.idx = self.idx+1
        root.left = self.helper(preorder,inorder,start,hashvalue-1,dictmap)
        root.right = self.helper(preorder,inorder,hashvalue+1,end,dictmap)
        return root
